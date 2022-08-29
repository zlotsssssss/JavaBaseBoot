package wx.th.zlo.javabaseboot.pqrst.t.thread.base;

//t.run()不会启动线程，单纯调用run方法而已
/* 常用方法 ：
            void setPriority(int newPriority)
            getPriority()
            void yield() ：让位方法，当前线程暂停，回到就绪状态，让给其它线程。
            join()
*/



public class Test {
    public static void main(String[] args) {
        RunningThread zloThread = new RunningThread("z");
        RunningThread sjgThread = new RunningThread("s");
        RunningThread sjgThread1 = new RunningThread("j");
        zloThread.setPriority(10);
        zloThread.start();
        sjgThread.start();

        sjgThread1.start();
        Thread thread = Thread.currentThread();
        System.out.println("1");


    }
}
class RunningThread extends  Thread{

    public RunningThread(String name) {
        super(name);
    }
    @Override
    public void run() {

        for (int i =  0 ; i < 5 ; i++){
            System.out.println(this.getName()+":"+i);
        }
    }
}
