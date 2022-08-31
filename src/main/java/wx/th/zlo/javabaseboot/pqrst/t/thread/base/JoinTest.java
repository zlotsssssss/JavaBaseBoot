package wx.th.zlo.javabaseboot.pqrst.t.thread.base;

//当有线程join到当前线程，当前线程被阻塞，等待加入线程执行完毕，才能进去就绪状态

// join(long millis):等待该线程终止的时间最长为 millis 毫秒,等待millis后继续执行,在等待时间内，该线程运行结束，继续运行

public class JoinTest {
    public static void main(String[] args) {
        System.out.println("开始主线程");
        JoinThread joinThread = new JoinThread();
        joinThread.start();
        try {
            joinThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("join线程执行完毕，继续主线程");
    }
}

class JoinThread extends  Thread{
    @Override
    public void run() {
        for (int i = 0 ; i < 10 ; i++){
            System.out.println(currentThread().getName()+ ":" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
