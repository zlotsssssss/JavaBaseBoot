package wx.th.zlo.javabaseboot.klmno.l.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    //读写锁
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    private final static Lock writeLock = readWriteLock.writeLock();

    private final static Lock readLock = readWriteLock.readLock();

    private final static List<Long> longs =new ArrayList<Long>();

    public static void main(String[] args) throws InterruptedException {

       // TimeUnit.SECONDS.sleep(3);
        new Thread(ReentrantReadWriteLockTest::read).start();
        new Thread(ReentrantReadWriteLockTest::read).start();
        new Thread(ReentrantReadWriteLockTest::read).start();
        new Thread(ReentrantReadWriteLockTest::write).start();
        new Thread(ReentrantReadWriteLockTest::read).start();
        new Thread(ReentrantReadWriteLockTest::read).start();


    }

    static void write() {

        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " write ");
            TimeUnit.SECONDS.sleep(2);
            longs.add(System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
    static void read() {
        try {
            readLock.lock();
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + " read ");
            longs.forEach(x -> System.out.println(x));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

}
