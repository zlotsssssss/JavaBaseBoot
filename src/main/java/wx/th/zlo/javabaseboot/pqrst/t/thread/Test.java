package wx.th.zlo.javabaseboot.pqrst.t.thread;



class RunningThread extends  Thread{
    public RunningThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i =  0 ; i < 5 ; i++){

            System.out.println(this.getName()+"running:"+i);
        }
    }
}


public class Test {
    public static void main(String[] args) {
        RunningThread zloThread = new RunningThread("zlo");
        RunningThread sjgThread = new RunningThread("sjg");
        RunningThread sjgThread1 = new RunningThread("sjg1");
        zloThread.start();
        sjgThread.start();
        sjgThread1.start();
        System.out.println("1");
    }
}
