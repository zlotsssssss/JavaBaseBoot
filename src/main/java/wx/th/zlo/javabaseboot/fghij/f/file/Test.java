package wx.th.zlo.javabaseboot.fghij.f.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        char[] arr=new char[19];
        String ss="daddda";
        File fl = new File("D:\\A.txt");
        try {


            if (fl.exists() == false) {

                fl.createNewFile();

            }
            FileOutputStream fw=new FileOutputStream(fl);
            fw.write(ss.getBytes(StandardCharsets.UTF_8));

            FileReader Q=new FileReader(fl);
            int t= Q.read(arr);

            for (int i = 0; i < t; i++) {
                System.out.print(arr[i]);
            }

            //System.out.println(arr);

            fw.close();



        }catch (Exception e){

            System.out.println("异常");
        }
    }


}
