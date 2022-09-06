package wx.th.zlo.javabaseboot.klmno.l.io;

import org.junit.Test;

import java.io.*;

/*
字符流：Reader、Writer，用于读取字符，如文本 abc中国人，只能用reader读取，用fileinputstream会报错
1. read():返回读入的一个字符，如果达到文件末尾，则返回-1
2. 异常处理：为了保证流的关闭，用try-catch-finally 关闭
3. Reader是一个字符一个字符读取的，FileReader实例化，时候可能会抛出文件不存在异常

4. Writer可能会抛出IO异常

5. Writer和Reader能操作图片之类（二进制文件），但是操作之后的图片不在是图片，如copy图片，复制出来的图片被破坏
 */

public class FileReaderWriterTest {

    @Test
    public void read() {
        Reader reader = null;
        try {

            //文件对象
            File file = new File("src/main/java/wx/th/zlo/javabaseboot/klmno/l/io/test.txt");
            //流对象
            reader = new FileReader(file);
            int read ;
            int num = 0 ;
            while((read = reader.read()) != -1 ){
                System.out.print((char)read);
                num++;
            }
            System.out.println();
            System.out.println("调用read函数次数："+num);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void readBuffer(){
        FileReader fr = null;
        try {
            File file = new File("src/main/java/wx/th/zlo/javabaseboot/klmno/l/io/test.txt");
            fr = new FileReader(file);
            char[] cbuf = new char[5];
            int len ;
            while((len = fr.read(cbuf)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
                //方法二：
                //String s = new String(cbuf, 0, len);
                //System.out.print(s);
            }
        } catch (Exception e) {
        } finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        write() 写 可能抛出io异常
     */
    @Test
    public void write(){
        File file = new File("src/main/java/wx/th/zlo/javabaseboot/klmno/l/io/writer.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write("i \n");
            writer.flush();
            writer.write("have \n");
            writer.write("a dream\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void copy(){
        Reader reader = null;
        Writer writer = null;
        try {
            File file = new File("src/main/java/wx/th/zlo/javabaseboot/klmno/l/io/writer.txt");
            File fileCopy = new File("src/main/java/wx/th/zlo/javabaseboot/klmno/l/io/writer_copy.txt");
            reader = new FileReader(file);
            writer = new FileWriter(fileCopy);
            char[] cbuf = new char[5];
            int len;
            while((len = reader.read(cbuf)) != -1){
                writer.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
