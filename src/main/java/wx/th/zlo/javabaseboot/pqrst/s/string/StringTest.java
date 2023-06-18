package wx.th.zlo.javabaseboot.pqrst.s.string;
/*
String用final char[] 指向字符常量池，
使用final,是申明char[]指向的字符串不会改变，也就不会存在线程问题，单单的声明作用。
 */

public class StringTest {
    public static void main(String[] args) {
        //用字符串直接赋值，s指向常量池，所以s1 == s2
        String s1 = "123";
        String s2 = "123";
        System.out.println(s1 == s2); //true

        //实例化String对象,s3指向堆中的对象，对象中的char[]指向常量池中的字符串
        String s3 = new String("123");
        String s4 = new String("123");
        System.out.println(s3 == s4 ); //false
    }
}
