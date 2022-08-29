package wx.th.zlo.javabaseboot.pqrst.t.thread.daemon;

//线程A创建线程B，线程B创建守护线程C，线程A结束了线程B未结束，线程C继续运行。也是说守护线程是否结束，是看做为哪个线程的守护线程。

public class DaemonTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");
        Thread thread = new Thread(new CustomRunable());
        thread.start();
        System.out.println("主线程结束");
    }
}

class CustomRunable implements Runnable{
    @Override
    public void run() {
        System.out.println("用户线程开始");
        Thread thread = new Thread(new DaemonRunable());
        thread.setDaemon(true);
        thread.start();
        System.out.println("用户线程结束");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class DaemonRunable implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("daemon");
        }
    }
}
