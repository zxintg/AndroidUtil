package com.zxin.javautil.design_mode;

/****
 * 单例模式实例化一个泛型对象
 *
 */
public class SingletonJavaT {
    private static SingletonJavaT t = null;

    private SingletonJavaT(){}

    /****
     * 懒汉模式
     * @return
     */
    public static SingletonJavaT getInstance(){
        if (t==null){
            synchronized (SingletonJavaT.class){
                if (t==null)
                    t = new SingletonJavaT();
            }
        }
        return t;
    }

    public static SingletonJavaT getInstance1() {
        return Singleton.INSTANCE;
    }

    private static class Singleton {
        private static final SingletonJavaT INSTANCE = new SingletonJavaT();
    }


}
