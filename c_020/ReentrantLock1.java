package ReadAgain.bingFa.c_020;

import java.util.concurrent.TimeUnit;

/**
 * reentrantlock 用于替代 synchronized
 * 本例中由于 m1 锁定 this,只有 m1 执行完毕的时候, m2 才能执行
 * 这里是复习 synchronized 最原始的语义
 * @author mashibing
 */

public class ReentrantLock1 {
    synchronized void m1() {
        for(int i=0; i<10; i++) {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(i);
        }
    }

    synchronized void m2() {
        System.out.println("m2 ...");
    }

    public static void main(String[] args) {
        ReentrantLock1 rl = new ReentrantLock1();
        new Thread(rl::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(rl::m2).start();
    }
}
