package wx.th.zlo.javabaseboot.test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface HelloWorld {
	public void sayHelloWorld();
}

class HelloWorldImpl implements HelloWorld{

	public void sayHelloWorld() {
		 {
				System.out.println("1");
				System.out.println("1");
				System.out.println("1");
			}
	}
	
}

public class ProxyExample implements InvocationHandler {
    private Object target;
    /**
     * 创建代理，将真实对象的类、构造方法等信息告诉代理类并将代理类返回，此时代理类拥有真实类的一切，
     * 甚至就可以直接看作是真实类的实例。
     * @param target
     * @return
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader() , target.getClass().getInterfaces() , this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
        System.out.println("123" + method.getName() + args);
        Object obj = method.invoke(target , args);
        System.out.println("123");
        return obj;
    }
    public static void main(String[] args) {
        ProxyExample example = new ProxyExample();
        HelloWorld proxy = (HelloWorld) example.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }
}


