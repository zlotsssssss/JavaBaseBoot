package wx.th.zlo.javabaseboot.pqrst.t.thread.threadpool;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
拒绝策略（handler）:
    AbortPolicy（默认）：丢弃任务并抛出 RejectedExecutionException 异常。
    CallerRunsPolicy：由调用线程处理该任务。
    DiscardPolicy：丢弃任务，但是不抛出异常。可以配合这种模式进行自定义的处理方式。
    DiscardOldestPolicy：丢弃队列最早的未处理任务，然后重新尝试执行任务。

 */
/*
corePoolSize：核心线程数，也是线程池中常驻的线程数，线程池初始化时默认是没有线程的，当任务来临时才开始创建线程去执行任务
maximumPoolSize：最大线程数，在核心线程数的基础上可能会额外增加一些非核心线程，
                需要注意的是只有当workQueue队列填满时才会创建多于corePoolSize的线程(线程池总线程数不超过maxPoolSize)
keepAliveTime：非核心线程的空闲时间超过keepAliveTime就会被自动终止回收掉，注意当corePoolSize=maxPoolSize时，keepAliveTime参数也就不起作用了(因为不存在非核心线程)；
unit：keepAliveTime的时间单位
workQueue：用于保存任务的队列，可以为无界、有界、同步移交三种队列类型之一，当池子里的工作线程数大于corePoolSize时，这时新进来的任务会被放到队列中
threadFactory：创建线程的工厂类，默认使用Executors.defaultThreadFactory()，也可以使用guava库的ThreadFactoryBuilder来创建
handler：线程池无法继续接收任务(队列已满且线程数达到maximunPoolSize)时的饱和策略，取值有AbortPolicy、CallerRunsPolicy、DiscardOldestPolicy、DiscardPolicy

 */
public class ExecutorTest {
    public static void main(String[] args) {
        //这里默认拒绝策略为AbortPolicy
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,4,4L, TimeUnit.SECONDS,new ArrayBlockingQueue(1));
        executor.allowCoreThreadTimeOut(true);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        for (Integer i : integers){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName("zlo"+i);
                    for(int i = 0 ; i < 3 ; i++){
                        System.out.println( Thread.currentThread().getName());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            });
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ok");
        System.out.println("ok");
    }
}
