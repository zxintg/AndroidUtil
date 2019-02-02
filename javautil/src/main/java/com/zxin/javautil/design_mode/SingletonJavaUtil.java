package com.zxin.javautil.design_mode;

/****
 * 单例模式实例化一个泛型对象
 *
 */
public class SingletonJavaUtil {

    //volatile关键字的一个作用是禁止指令重排，把instance声明为volatile之后，
    // 对它的写操作就会有一个内存屏障（什么是内存屏障？），
    // 这样，在它的赋值完成之前，就不用会调用读操作。
    private static volatile  SingletonJavaUtil t = null;

    private SingletonJavaUtil(){}

    /****
     * 懒汉模式
     * @return
     */
    public static SingletonJavaUtil getLazyInstance(){
        if (t==null){
            synchronized (SingletonJavaUtil.class){
                if (t==null)
                    t = new SingletonJavaUtil();
            }
        }
        return t;
    }


    /****
     * 在SingletonHolder初始化的时候会由ClassLoader来保证同步，使INSTANCE是一个真·单例。
     * @return
     */
    public static SingletonJavaUtil getHungerInstance() {
        return Singleton.INSTANCE;
    }

    /***
     * 饿汉模式
     * @return
     */
    private static class Singleton {
        private static final SingletonJavaUtil INSTANCE = new SingletonJavaUtil();
    }
}
