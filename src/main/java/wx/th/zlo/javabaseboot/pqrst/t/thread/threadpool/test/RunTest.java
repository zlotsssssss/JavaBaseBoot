package wx.th.zlo.javabaseboot.pqrst.t.thread.threadpool.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
//https://blog.csdn.net/qq_38826019/article/details/120245945
class  Worker implements Runnable{
    final  Thread thread;

    Runnable firstTask ;

    List<Runnable> taskList = new ArrayList<>();

    Worker(Runnable runnable) {
        this.firstTask = runnable;
        this.thread = Executors.defaultThreadFactory().newThread(this);

    }

    public void addTask(Runnable runnable){
        this.taskList.add(runnable);
    }

    @Override
    public void run() {
        runWorker(this);
    }
    final void runWorker(Worker w){
        Runnable task = w.firstTask;
        Iterator<Runnable> iterator = taskList.iterator();
        try {
            while(task != null || iterator.hasNext()){

                if(task == null) {
                    task = iterator.next();
                }
                   task.run();
                task =null;

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


public class RunTest {
    public static void main(String[] args) {
        Worker worker = new Worker(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("第一个线程");
                try {
                    System.out.println("线程一睡眠3秒");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        worker.addTask(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("第二个线程");
                try {
                    System.out.println("线程二睡眠3秒");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread = worker.thread;
        thread.start();
    }
}
