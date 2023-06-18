package wx.th.zlo.javabaseboot.pqrst.t.thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/*
系统委派一个线程去执行一个任务，该线程执行完任务之后，可能会有一个执行结果，我们怎么能拿到这个执行结果呢？
使用第三种方式：实现Callable接口方式。
 */

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(3000);
                return 1;
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(1);
        Object o = futureTask.get();
        System.out.println((int)o);
    }
}


