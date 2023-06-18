package wx.th.zlo.javabaseboot.abcde.c.code;

import org.junit.Test;

import java.io.FileInputStream;

/*
  UTF-8编码,可以变长度 字符编码
  0xxxxxxx 兼容ASCII
  110xxxxx 10xxxxxx
  1110xxxx 10xxxxxx 10xxxxxx  3个字符，中文编码
  11110xxx 10xxxxxx 10xxxxxx 10xxxx
 */
public class UTF8 {
    @Test
    public void test() throws  Exception{
        FileInputStream fis = new FileInputStream("src/main/java/wx/th/zlo/javabaseboot/abcde/c/code/utf-8.txt");
        byte[] bytes = new byte[4];
        fis.read(bytes);
        for(byte b : bytes){
          int bit =   (b & 0xff);
         // System.out.println(b);
          System.out.println(byteToBit(b));
        }
    }

    public static String byteToBit(byte b) {

        return "" +(byte)((b >> 7) & 0x1) +

                (byte)((b >> 6) & 0x1) +

                (byte)((b >> 5) & 0x1) +

                (byte)((b >> 4) & 0x1) +

                (byte)((b >> 3) & 0x1) +

                (byte)((b >> 2) & 0x1) +

                (byte)((b >> 1) & 0x1) +

                (byte)((b >> 0) & 0x1);

    }

}
