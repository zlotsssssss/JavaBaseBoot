package wx.th.zlo.javabaseboot.pqrst.p.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    对java动态代理的理解：
               三部分组成：对象，代理对象，调用处理程序对象。
               对象和代理对象是同类型的对象
               代理对象的方法调用会被分配到调用处理程序对象中
               调用处理程序对象是实现了InvocationHandler接口，实现了增强的功能。

 */
/*
案例说明：
功能：通过proxy，给用户界面的login方法增强一个功能，成功登录后，实现用户在黑名单中，无法登录
 */


//创建用户界面，实现登录方法
interface IUserInterface{
    Boolean login (String name,String password);
}
class UserInterface implements  IUserInterface{

    @Override
    public Boolean login(String name, String password) {
       if("zlo".equals(name) && "123".equals(password)){
           return  true;
       }
       return false;
    }
}
//通过proxy，给用户界面的login方法增强一个功能，成功登录后，实现用户在黑名单中，无法登录
class ProxyUserInterface implements InvocationHandler {
    Object target;

    List<String> blackList;

    public ProxyUserInterface() {
    }

    public ProxyUserInterface(Object target, List<String> blackList) {
        this.target = target;
        this.blackList = blackList;
    }
    /**
     * 方法描述:
     *
     * @param proxy 代理类
     * @param method 方法
     * @param args     参数
     * @return Object
     *
     * @变更记录 2022/9/5 8:59 周立瓯 创建
     *
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass());

        if((Boolean) method.invoke(target,args)){
                return  !blackList.contains(args[0].toString());
        }
            return  false;
    }
}

public class Test {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        List<String> blackLists = new ArrayList<String>(Arrays.asList("zlo1","sjg"));
        ProxyUserInterface proxyUserInterface = new ProxyUserInterface(userInterface,blackLists);
        IUserInterface proxyInstance = (IUserInterface)Proxy.newProxyInstance(userInterface.getClass().getClassLoader(), userInterface.getClass().getInterfaces(), proxyUserInterface);
        System.out.println(proxyInstance.getClass());
        Boolean zlo = proxyInstance.login("zlo", "123");
        System.out.println(zlo);
    }
}
