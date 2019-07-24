package ReadAgain.bingFa.c_025;

import java.util.concurrent.LinkedTransferQueue;

public class T08_TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

		/*new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();*/

       // strs.transfer("aaa");  // 不是添加到阻塞队列就完事了，而是线程阻塞等待直至有别人来完成

        strs.put("aaa");

        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
