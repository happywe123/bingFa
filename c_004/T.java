package ReadAgain.bingFa.c_004;

/**
 * synchronized 关键字
 * 对某个对象加锁
 *
 */

public class T {

    private static int count = 10;

    // 这里等同于 synchronized(T.class)
    public synchronized static void m(){
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(){
        synchronized(T.class){
            count--;
        }
    }
}
