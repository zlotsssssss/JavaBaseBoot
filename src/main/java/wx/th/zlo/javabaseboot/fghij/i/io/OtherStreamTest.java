package wx.th.zlo.javabaseboot.fghij.i.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1.标准的输入输出流
1.1
System.in:标准的输入流、默认为键盘的输入 InputStream
System.out:标准的输出流、默认控制台输出 PrintStream
1.2
System类的setIn（InputStream is）或者setOut（OutputStream out）方式重新指定输入输出流

 */


public class OtherStreamTest {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            reader= new BufferedReader(isr);
            while (true){
                System.out.println("请输入字符");
                char[] chars = new char[1];
                while((reader.read(chars,0,1)) != -1){
                    System.out.println(chars);
                }
                //String s = reader.readLine();
//                if("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)){
//                    System.out.println("程序结束");
//                    break;
//                }
//                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
