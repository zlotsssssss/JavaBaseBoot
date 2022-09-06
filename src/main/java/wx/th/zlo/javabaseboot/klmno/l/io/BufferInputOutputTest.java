package wx.th.zlo.javabaseboot.klmno.l.io;

import org.junit.Test;

import java.io.*;
/*
BufferedInputStream 在

 */

public class BufferInputOutputTest {
    @Test
    public void copy(){
        long start = System.currentTimeMillis();
        File file1 = new File("D:\\迅雷下载\\a.zip");
        File file2 = new File("D:\\迅雷下载\\c.zip");
        InputStream is = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            is = new FileInputStream(file1);
            os = new FileOutputStream(file2);
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);

            int len ;
            byte[] buf = new byte[1024];
            while ((len = bis.read(buf)) != -1){
                bos.write(buf, 0 ,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start); //854
    }
}
