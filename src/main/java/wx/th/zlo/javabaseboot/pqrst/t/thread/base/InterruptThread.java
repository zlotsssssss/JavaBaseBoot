package wx.th.zlo.javabaseboot.pqrst.t.thread.base;

//中断线程，在线程类或者runable类中，自定义一个标志变量，用于判断是否结束
//主线程睡眠，由主线程开启的线程依旧执行


public class InterruptThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        myThread.run = false;
        System.out.println("1");
    }
}
//自定义线程类
class MyThread extends  Thread{
    Boolean run =  true;
    @Override
    public void run() {
        while(run){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("running");
        }
    }
}
