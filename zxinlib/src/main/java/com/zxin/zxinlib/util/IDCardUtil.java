package com.zxin.zxinlib.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 身份证验证的工具（支持15位或18位省份证）
 * 身份证号码结构：
 * <p>
 * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
 * 排列顺序从左至右依次为：6位数字地址码，8位数字出生日期码，3位数字顺序码和1位数字校验码。
 * <p>
 * 地址码（前6位）：表示对象常住户口所在县（市、镇、区）的行政区划代码，按GB/T2260的规定执行。
 * <li>前1、2位数字表示：所在省份的代码；</li>
 * <li>第3、4位数字表示：所在城市的代码；</li>
 * <li>第5、6位数字表示：所在区县的代码；</li>
 * <p>
 * 出生日期码，（第7位 - 14位）：表示编码对象出生年、月、日，按GB按GB/T7408的规定执行，年、月、日代码之间不用分隔符。
 * <p>
 * 顺序码（第15位至17位）：表示在同一地址码所标示的区域范围内，对同年、同月、同日出生的人编订的顺序号，顺序码的奇数分配给男性，偶数分配给女性。
 * <li>第15、16位数字表示：所在地的派出所的代码；</li>
 * <li>第17位数字表示性别：奇数表示男性，偶数表示女性；</li>
 * <li>第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证的正确性。校检码可以是0~9的数字，有时也用x表示。</li>
 * <p>
 * 校验码（第18位数）：
 * <p>
 * 十七位数字本体码加权求和公式 s = sum(Ai*Wi), i = 0..16，先对前17位数字的权求和；
 * Ai:表示第i位置上的身份证号码数字值.Wi:表示第i位置上的加权因子.Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2；
 * 计算模 Y = mod(S, 11)
 * 通过模得到对应的模 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0 X 9 8 7 6 5 4 3 2
 * <p>
 * 计算步骤：
 * 1.将前17位数分别乘以不同的系数。从第1位到第17位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
 * 2.将这17位数字和系数相乘的结果相加。
 * 3.用加出来和除以11，看余数是多少
 * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字，分别对应的最后一位身份证的号码为：1 0 X 9 8 7 6 5 4 3
 * <p>
 * 我的Java学习交流QQ群：589809992 我们一起学Java！
 */
public class IDCardUtil {
    final static Map<Integer, String> zoneNum = new HashMap<Integer, String>();

    static {
        zoneNum.put(11, "北京");
        zoneNum.put(12, "天津");
        zoneNum.put(13, "河北");
        zoneNum.put(14, "山西");
        zoneNum.put(15, "内蒙古");
        zoneNum.put(21, "辽宁");
        zoneNum.put(22, "吉林");
        zoneNum.put(23, "黑龙江");
        zoneNum.put(31, "上海");
        zoneNum.put(32, "江苏");
        zoneNum.put(33, "浙江");
        zoneNum.put(34, "安徽");
        zoneNum.put(35, "福建");
        zoneNum.put(36, "江西");
        zoneNum.put(37, "山东");
        zoneNum.put(41, "河南");
        zoneNum.put(42, "湖北");
        zoneNum.put(43, "湖南");
        zoneNum.put(44, "广东");
        zoneNum.put(45, "广西");
        zoneNum.put(46, "海南");
        zoneNum.put(50, "重庆");
        zoneNum.put(51, "四川");
        zoneNum.put(52, "贵州");
        zoneNum.put(53, "云南");
        zoneNum.put(54, "西藏");
        zoneNum.put(61, "陕西");
        zoneNum.put(62, "甘肃");
        zoneNum.put(63, "青海");
        zoneNum.put(64, "宁夏");
        zoneNum.put(65, "新疆");
        zoneNum.put(71, "台湾");
        zoneNum.put(81, "香港");
        zoneNum.put(82, "澳门");
        zoneNum.put(91, "国外");
    }

    final static int[] PARITYBIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
    final static int[] POWER_LIST = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /**
     * 身份证号是否基本有效
     *
     * @param s 号码内容
     * @return 是否有效，null和""都是false
     */
    public static boolean isIdcard(String s) {
        if (s == null || (s.length() != 15 && s.length() != 18))
            return false;
        final char[] cs = s.toUpperCase().toCharArray();
        // （1）校验位数
        int power = 0;
        for (int i = 0; i < cs.length; i++) {// 循环比正则表达式更快
            if (i == cs.length - 1 && cs[i] == 'X')
                break;// 最后一位可以是X或者x
            if (cs[i] < '0' || cs[i] > '9')
                return false;
            if (i < cs.length - 1)
                power += (cs[i] - '0') * POWER_LIST[i];
        }
        // （2）校验区位码
        if (!zoneNum.containsKey(Integer.valueOf(s.substring(0, 2)))) {
            return false;
        }
        // （3）校验年份
        String year = s.length() == 15 ? "19" + s.substring(6, 8) : s.substring(6, 10);
        final int iyear = Integer.parseInt(year);
        if (iyear < 1900 || iyear > Calendar.getInstance().get(Calendar.YEAR)) {
            return false;// 1900年的PASS，超过今年的PASS
        }
        // （4）校验月份
        String month = s.length() == 15 ? s.substring(8, 10) : s.substring(10, 12);
        final int imonth = Integer.parseInt(month);
        if (imonth < 1 || imonth > 12)
            return false;
        // （5）校验天数
        String day = s.length() == 15 ? s.substring(10, 12) : s.substring(12, 14);
        final int iday = Integer.parseInt(day);
        if (iday < 1 || iday > 31)
            return false;
        // （6）校验一个合法的年月日
        if (!validate(iyear, imonth, iday))
            return false;
        // （7）校验“校验码”
        if (s.length() == 15)
            return true;
        return cs[cs.length - 1] == PARITYBIT[power % 11];
    }

    static boolean validate(int year, int month, int day) {
        // 比如考虑闰月，大小月等
        return true;
    }


}