package wx.th.zlo.javabaseboot.pqrst.p.proxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import wx.th.zlo.javabaseboot.aabase.Student;

import java.lang.reflect.Method;

class StudentInterceptor implements MethodInterceptor{
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("之前");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("之后");
        return o1;
    }
}

public class Test {
    public static void main(String[] args) {
        //String location = Test.class.getResource("").getPath().replaceAll("%20"," ") + "debugging/";
      //  System.out.println(location);
       // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, location);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback(new StudentInterceptor());
        Student stu = (Student)enhancer.create();
        stu.greet();
    }
}
