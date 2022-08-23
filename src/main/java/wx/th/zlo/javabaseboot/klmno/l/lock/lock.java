package wx.th.zlo.javabaseboot.klmno.l.lock;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class T {
    List<String> lists;

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }
}

/*
    ReentrantReadWriteLock的简单使用。在可能存在异步问题的代码前面加上，lock.writeLock().lock();后面加上lock.writeLock().unlock();
 */
public class lock {
    static  ReadWriteLock lock = new ReentrantReadWriteLock();
    static int sum = 100;
    public static void main(String[] args) {
        T t = new T();
        t.setLists(null);
        //用线程池开启线程，测试lock.writeLock().lock();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        try {
                            lock.writeLock().lock();
                            sum -= 1;
                            System.out.println(sum);
                        } finally {
                            lock.writeLock().unlock();
                        }
                    }

                }
            });
        }


    }
}
