package ReadAgain.bingFa.c_022;

/**
 * ThreadLocal线程局部变量
 *
 * ThreadLocal 是使用空间换时间，synchronized 是使用时间换空间
 * 比如在 hibernate 中 session 就存在与 ThreadLocal 中，避免 synchronized 的使用
 *
 * 运行下面的程序，理解ThreadLocal
 *
 * @author 马士兵
 */

import java.util.concurrent.TimeUnit;

public class ThreadLocal2 {
    //volatile static Person p = new Person();
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(tl.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }

    static class Person {
        String name = "zhangsan";
    }
}
