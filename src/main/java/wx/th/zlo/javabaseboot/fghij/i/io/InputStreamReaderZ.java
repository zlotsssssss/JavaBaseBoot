package wx.th.zlo.javabaseboot.fghij.i.io;

import org.junit.Test;

import java.io.*;

public class InputStreamReaderZ {
        @Test
        public void test() throws Exception {
            //File file = new File("src/main/java/wx/th/zlo/javabaseboot/klmno/l/io/test.txt");
            FileInputStream fis = new FileInputStream("src/main/java/wx/th/zlo/javabaseboot/fghij/i/io/test.txt");
            FileOutputStream fos = new FileOutputStream("src/main/java/wx/th/zlo/javabaseboot/fghij/i/io/test_gbk.txt");


            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            OutputStreamWriter osr = new OutputStreamWriter(fos,"gbk");
            char[] buf = new char[20];
            int len ;
            while ( (len=isr.read(buf)) != -1){
                String s = new String(buf, 0, len);
                System.out.print(s);
                osr.write(buf,0,len);
            }
            isr.close();
            osr.close();


        }
}
