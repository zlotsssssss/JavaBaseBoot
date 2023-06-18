package wx.th.zlo.javabaseboot.fghij.i.io;

import wx.th.zlo.javabaseboot.aabase.Student;

import java.io.*;

/**
 * 对象流
 */
public class ObjectStream {
    public static void main(String[] args)  throws  Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/wx/th/zlo/javabaseboot/fghij/i/io/Object.txt"));
        Student student = new Student();
        student.setAge("18");
        student.setName("zlo");
        student.setSex("男");
        oos.writeObject(student);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/wx/th/zlo/javabaseboot/fghij/i/io/Object.txt"));
        Student o = (Student)ois.readObject();
        System.out.println(o.getAge());
    }
}
