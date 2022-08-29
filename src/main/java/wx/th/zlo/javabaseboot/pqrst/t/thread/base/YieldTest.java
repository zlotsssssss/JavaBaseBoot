package wx.th.zlo.javabaseboot.pqrst.t.thread.base;

//yield :让位，当前线程暂停，回到就绪状态，让给其它线程。
//特点：不释放锁

public class YieldTest {
    public static void main(String[] args) {
        YieldThread yieldThread = new YieldThread("1");
        yieldThread.start();
        YieldThread yieldThread1 = new YieldThread("2");
        yieldThread1.start();
    }
}
class YieldThread extends Thread{
    public YieldThread(String name) {
        super(name);
    }

    @Override
    public void run() {
            for (int i = 0 ; i < 10 ; i++){
                if("1".equals(currentThread().getName())){
                    if(i % 3 == 0) yield();
                }
                System.out.println(currentThread().getName()+":" + i);
            }
    }
}
