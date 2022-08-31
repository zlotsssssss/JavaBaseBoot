package wx.th.zlo.javabaseboot.pqrst.t.thread.waitAndnotify;

import java.util.concurrent.TimeUnit;

/*
void notify()	唤醒当前对象正在等待的线程（只提示唤醒，不会释放锁）
测试Notify：模拟线程之间通讯
 */
public class NotifyTest {
    static Object lock = new Object();
    public static void main(String[] args) {
        //让线程一等待lock对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程一开始");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("线程一重新获得锁和调度");
                }
            }
        }).start();

       //线程二唤醒等待lock的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lock.notifyAll();
                }
            }
        }).start();
    }
}
