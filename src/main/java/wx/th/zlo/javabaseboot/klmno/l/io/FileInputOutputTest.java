package wx.th.zlo.javabaseboot.klmno.l.io;

import org.hibernate.result.Output;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
/*
    FileOutputStream无缓存
 */



public class FileInputOutputTest {
    @Test
    public void fileInput(){
        File file = new File("src/main/java/wx/th/zlo/javabaseboot/klmno/l/io/test.txt");
        FileInputStream is = null;
        try {
            is = new FileInputStream(file);
            byte[] buf = new byte[3];
            int len ;
            while ((len = is.read(buf)) != -1){
                System.out.println(new String(buf,0,len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void fielOutput(){
        File file = new File("src/main/java/wx/th/zlo/javabaseboot/klmno/l/io/test.txt");
        OutputStream os = null ;

        try {
            os = new FileOutputStream(file);
            os.write("a".getBytes(StandardCharsets.UTF_8));
            os.write("b".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public  void  copy(){
        long start = System.currentTimeMillis();
        File file1 = new File("D:\\迅雷下载\\a.zip");
        File file2 = new File("D:\\迅雷下载\\b.zip");
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(file1);
            os = new FileOutputStream(file2);
            int len ;
            byte[] buf = new byte[1024];
            while ((len = is.read(buf)) != -1){
                os.write(buf, 0 ,len);
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
        System.out.println(end - start); //3401


    }
}
