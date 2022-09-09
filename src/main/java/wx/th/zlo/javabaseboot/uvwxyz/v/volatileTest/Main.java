package wx.th.zlo.javabaseboot.uvwxyz.v.volatileTest;
class Solution implements Runnable {

    private int threadId;

    private Object o;

    // You can add other member variables needed.
    // -- write your code here --
    private    Integer printNum ;

    public Solution(int threadId, Object o,Integer i) {
        this.threadId = threadId;
        this.o = o;
        printNum = i;
    }

    @Override
    public void run() {
        // -- write your code here --
        while( printNum <= 28){
            synchronized(o){
                if( printNum / 5 % 3 + 1 == threadId){
                    if(printNum <= 28){
                        for(int i = 0 ; i < 5 ; i++){
                            if(printNum <= 28){
                                System.out.println("Thread " + threadId + ": " + printNum++);
                            }
                        }
                    }
                    System.out.println(threadId + "唤醒");
                    o.notifyAll();
                }else{

                    try {
                        System.out.println(threadId + "睡眠");
                        o.wait();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }


    }
}
public class Main {
    static  volatile  Integer  i = 0;

    public static void main(String[] args) {

        Object o = new Object();



        try {
            new Thread(new Solution(1, o,i)).start();
            new Thread(new Solution(2, o,i)).start();
            new Thread(new Solution(3, o,i)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}