package ReadAgain.bingFa.c_001;

/**
 * synchronized 关键字
 * 对某个对象加锁
 *
 */

public class T {

    private int count = 10;
    private Object o = new Object();

    public void m(){
        synchronized(o) {   // 任何线程要想执行下面的代码，必须先拿到 o 的对象
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }
}
