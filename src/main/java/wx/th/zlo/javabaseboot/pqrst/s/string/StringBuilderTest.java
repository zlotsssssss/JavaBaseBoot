package wx.th.zlo.javabaseboot.pqrst.s.string;

public class StringBuilderTest {
    public static void main(String[] args) {
        final int count = 10000;
        long start = System.currentTimeMillis();
        StringBuilder s = new StringBuilder("");
        for (int i = 0 ; i < count ; i++){
            s.append(String.valueOf(i));
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder花时间："+ (end-start));

        long start2 = System.currentTimeMillis();
        String s2 = "";
        for (int i = 0 ; i < count ;i++){
            s2 += String.valueOf(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("String花时间："+ (end2-start2));
    }
}
