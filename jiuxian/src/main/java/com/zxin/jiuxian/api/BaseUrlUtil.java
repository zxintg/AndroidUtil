package com.zxin.jiuxian.api;

import com.zxin.jiuxian.util.JiuXianSharedPreferences;

/**
 * Created by Administrator on 2018/8/13.
 */

public class BaseUrlUtil {
    public static boolean isLog = false;
    private static boolean b = true;
    private static int c = 1100;
    private static boolean d;

    public static int a() {
        g();
        return c;
    }

    public static boolean b() {
        g();
        return c == 1200;
    }

    public static boolean c() {
        g();
        return c == 1102;
    }

    public static boolean d() {
        g();
        return c == 1201;
    }

    public static boolean e() {
        g();
        return c == 1300;
    }

    public static boolean f() {
        g();
        return c == 1400;
    }

    private static void g() {
        boolean bool = d;
        if (bool) {
            return;
        }
        int i = JiuXianSharedPreferences.server_mode_type();
        if (i >= 1000 && i <= 1400) {
            c = i;
        }
        if (b && !isLog) {
            c = 1400;
        }
        d = true;
    }
}
