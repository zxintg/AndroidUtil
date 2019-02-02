package com.zxin.javautil.design_mode;

/****
 * 工厂模式
 *
 *
 * （1）简单工厂（Simple Factory）模式，又称静态工厂方法模式（Static Factory Method Pattern）。
 * （2）工厂方法（Factory Method）模式，又称多态性工厂（Polymorphic Factory）模式或虚拟构造子（Virtual Constructor）模式；
 * （3）抽象工厂（Abstract Factory）模式，又称工具箱（Kit 或Toolkit）模式。
 *
 */
public class FactoryJavaUtil {

    /*****
     * 简单工厂
     * @param className
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T>  T getProduceInstance(String className) throws Exception {
        try {
            T product = (T) Class.forName(className).newInstance();
            return product;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new Exception("无法实例化："+className);
    }



}
