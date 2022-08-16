package wx.th.zlo.javabaseboot.abcde.c.collection.test;

//从抽象类开始 默认继承Object，抽象类实现接口，可以不具体实现
public abstract class AbstractPerson implements Person {
    String name = "1";
    public String getName()   {
        throw new UnsupportedOperationException();
    }
}
