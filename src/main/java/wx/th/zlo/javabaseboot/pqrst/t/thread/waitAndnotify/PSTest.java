package wx.th.zlo.javabaseboot.pqrst.t.thread.waitAndnotify;

import java.util.ArrayList;
import java.util.List;

/*
都是Object的方法
void wait()	    让活动在当前对象的线程无限等待（释放之前占有的锁）,wait( long timeout) :当线程超过了设置时间之后，自动恢复执行

void notifyAll()	唤醒当前对象全部正在等待的线程（只提示唤醒，不会释放锁）



 */
public class PSTest {
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();

        Thread pthread = new Thread(new Producer(list));
        Thread cthread = new Thread(new Consumer(list));
        cthread.setName("消费者");
        pthread.setName("生产者");
        cthread.start();

        Thread.sleep(1000);
        pthread.start();

    }
}

class Producer implements Runnable {

    List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() > 0) {
                    try {
                        System.out.println("进入");
                        list.wait(); //当前线程等待，释放锁，
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                list.add(new Object());
                System.out.println(Thread.currentThread().getName() + "--->当前个数" + list.size());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                list.notifyAll(); //notify函数中只是对线程进行了队列转移,唤醒线程
            }
        }
    }
}

class Consumer implements Runnable {

    List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (list) {
                if (list.size() == 0) {
                    try {
                        System.out.println("消费者，进入等待");
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                list.remove(0);
                System.out.println(Thread.currentThread().getName() + "--->当前个数" + list.size());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                list.notifyAll();

            }
        }
    }
}



