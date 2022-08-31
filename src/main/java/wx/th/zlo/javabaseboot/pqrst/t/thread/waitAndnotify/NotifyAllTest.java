package wx.th.zlo.javabaseboot.pqrst.t.thread.waitAndnotify;

import java.util.concurrent.TimeUnit;

/*
void notifyAll()	唤醒当前对象正在等待的所有线程（只提示唤醒，不会释放锁）
测试Notify：模拟线程之间通讯
 */
public class NotifyAllTest {
    static Object lock = new Object();
    public static void main(String[] args) {
        //线程一：
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

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程二开始");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("线程二重新获得锁和调度");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程三开始");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("线程三重新获得锁和调度");
                }
            }
        }).start();

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
