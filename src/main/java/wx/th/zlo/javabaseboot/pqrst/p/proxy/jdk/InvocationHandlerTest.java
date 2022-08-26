package wx.th.zlo.javabaseboot.pqrst.p.proxy.jdk;

import java.lang.reflect.Method;

/*
InvationHandler接口 是 proxy代理实例的调用处理程序实现的一个接口，每一个proxy代理实例都有
一个关联的调用处理程序。
当proxy实例调用方法，方法调用被编码分派到调用处理程序的invoke方法
 */
public interface InvocationHandlerTest {
    /**
     * proxy:代理类代理的真实代理对象com.sun.proxy.$Proxy0
     * method:我们所要调用某个对象真实的方法的Method对象
     * args:指代代理对象方法传递的参数
     */
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
