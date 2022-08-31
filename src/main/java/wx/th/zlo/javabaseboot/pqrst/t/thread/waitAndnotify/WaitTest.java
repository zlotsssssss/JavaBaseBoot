package wx.th.zlo.javabaseboot.pqrst.t.thread.waitAndnotify;

import java.time.LocalDateTime;

/*
    void wait()	    让活动在当前对象的线程无限等待（释放之前占有的锁）,
    void wait( long timeout) :当线程超过了设置时间之后，自动恢复执行。
synchronized : 获得对象的监视器，

每一个对象同一时刻只有一个锁monitor相关联，而一个monitor同一时间只能被一个线程获得。

 */
public class WaitTest {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(()->{
            synchronized (lock1){
                System.out.println("线程一：开始运行" + LocalDateTime.now());
                try {
                    lock1.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程一：运行完毕" + LocalDateTime.now());
            }
        }).start();
        new Thread(()->{
            synchronized (lock2){
                System.out.println("线程二：开始运行" + LocalDateTime.now());
                try {
                    lock2.wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程二：运行完毕" + LocalDateTime.now());
            }
        }).start();
    }
}
