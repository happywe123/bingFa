package ReadAgain.bingFa.c_015;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 解决同样的问题的更高效的方法，使用 AtomXXX 类
 * AtomXXX 类本身方法都是原子性的，但不能保证多个方法连续调用是原子性的
 */

public class T {
    AtomicInteger count = new AtomicInteger();

    /*synchronized*/ void m(){
        for(int i = 0; i < 10000; i++){
            count.incrementAndGet();  // count++
        }
    }

    public static void main(String[] args){
        T t = new T();

        List<Thread> threadList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            threadList.add(new Thread(t::m,"thread-" + i));
        }

        threadList.forEach((o)->o.start());
        threadList.forEach((o)->{
            try{
                o.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
