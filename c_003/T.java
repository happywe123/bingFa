package ReadAgain.bingFa.c_003;

/**
 * synchronized 关键字
 * 对某个对象加锁
 *
 */

public class T {

    private int count = 10;

    public synchronized void m(){   // 等同于在方法的代码执行时要 synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
