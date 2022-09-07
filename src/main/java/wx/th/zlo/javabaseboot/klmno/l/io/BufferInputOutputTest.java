package wx.th.zlo.javabaseboot.klmno.l.io;

import org.junit.Test;

import java.io.*;
/*
BufferedInputStream:  默认直接从硬盘一下子缓存8 * 1024个字节（8kb），每次read多少，从这个缓存里面读取，不够再缓存8*1024。
BufferedOutputStream: 每次write写到缓存区8 * 1024个字节（8kb），满了才flush写到硬盘

 */

public class BufferInputOutputTest {
    @Test
    public void copy(){
        long start = System.currentTimeMillis();
        File file1 = new File("D:\\迅雷下载\\a.zip");
        File file2 = new File("D:\\迅雷下载\\h.zip");
        InputStream is = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        int number = 0;
        try {
            is = new FileInputStream(file1);
            os = new FileOutputStream(file2);
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);

            int len ;
            byte[] buf = new byte[1024*100];

            while ((len = bis.read(buf)) != -1){
                bos.write(buf, 0 ,len);
                number++;
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
        System.out.println(end - start); //2694
        System.out.println(number);
    }
}
