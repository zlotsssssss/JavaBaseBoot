package wx.th.zlo.javabaseboot.pqrst.s.string;

public class StringBufferTest {
    public static void main(String[] args) {
        final int count = 100000;




        long start3 = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer("");
        for (int i = 0 ; i < count ; i++){
            buffer.append(String.valueOf(i));
        }
        long end3 = System.currentTimeMillis();
        System.out.println("StringBuffer花时间："+ (end3-start3));
        
        
    }
}
