package wx.th.zlo.javabaseboot.klmno.l.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//用ReentrantWriteAndReadLock 实现 ArrayList 的线程安全.
/*
    实现原理：在对ArrayList进行读写操作时候，加上写锁和读锁
 */
public class ReentrantList<E> {
    private List<E> list = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock writeLock = lock.writeLock();

    private final Lock readLock = lock.readLock();

    public void add(E element){
        writeLock.lock();
        try {
            list.add(element);
        }finally {
            writeLock.unlock();
        }
    }

    public E get(int index){
        readLock.lock();
        try {
            return list.get(index);
        }finally {
            readLock.unlock();
        }
    }

    public int size(){
        readLock.lock();
        try {
            return list.size();
        }finally {
            readLock.unlock();
        }
    }
}
