package ReadAgain.bingFa.c_002;

/**
 * synchronized 关键字
 * 对某个对象加锁
 *
 */

public class T {

    private int count = 10;

    public void m() {
        synchronized(this){   // 任何线程要想执行这些代码，必须先拿到这个对象
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count );
        }
    }
}
