package wx.th.zlo.javabaseboot.abcde.e.extend;


class  Person{
    int a = 1;
    public void say(){
        System.out.println("person"+a);
    }
}
class Boy extends  Person{
    int a = 2;
    public void say() {
        super.say();
        System.out.println("boy"+a);
    }
}
public class ExtendsTest {
    public static void main(String[] args) {
        Person boy = (Person) new Boy();
        boy.say();
    }
}
