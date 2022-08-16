package wx.th.zlo.javabaseboot.abcde.c.collection.test;


//实现类Student 已经继承了实现Person接口的AbstractPerson，又要实现 Person接口，
//在理论上，每个实现类在某些接口方法都有特定的实现，所以需要重新实现
public class Student extends  AbstractPerson  implements  Person{
    @Override
    public String getName() {
        return name;
    }
}
