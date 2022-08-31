package wx.th.zlo.javabaseboot.pqrst.t.thread.base;
/*
synchronized 关键字: 执行synchronized中的代码，必须获得锁对象的监视器，当锁对象的监视器被其他线程占用，只能等其他线程释放，进入
 */

import wx.th.zlo.javabaseboot.klmno.l.lock.lock;

public class SynchronizedTest {
    static Integer number = 20;
    static Object lock = new Object();


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        synchronized (lock) {
                            if (number > 0) {
                                System.out.println(number--);
                            }
                        }
                    }
                }
            }).start();
        }
    }
}
