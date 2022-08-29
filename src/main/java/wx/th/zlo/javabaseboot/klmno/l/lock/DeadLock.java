package wx.th.zlo.javabaseboot.klmno.l.lock;

//死锁：A线程需要的资源被正在被B线程占有，B线程需要的资源正在被A线程占有

public class DeadLock {
    public static void main(String[] args) {
        Dress dress = new Dress();
        Trousers trousers = new Trousers();
        String s1 = "1";
        String s2 = "2";
        AddThread thread1 = new AddThread(s1, s2);
        AddThread1 thread2 = new AddThread1(s1, s2);
        thread1.start();
        thread2.start();
    }
}
class AddThread extends  Thread{
    Dress a;
    Trousers  b;

    String s1;

    String s2;

    public AddThread(Dress a, Trousers b) {
        this.a = a;
        this.b = b;
    }
    public AddThread(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
    @Override
    public void run() {
        synchronized (s1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (s2){
                System.out.println(s1);
            }
        }
    }
}
class AddThread1 extends  Thread{
    Dress a;
    Trousers  b;
    String s1;

    String s2;


    public AddThread1(Dress a, Trousers b) {
        this.a = a;
        this.b = b;
    }

    public AddThread1(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        synchronized (s2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (s1){
                System.out.println(s2);
            }
        }
    }
}
class Dress{

}

class Trousers{

}
