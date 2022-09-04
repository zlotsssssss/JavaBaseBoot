package wx.th.zlo.javabaseboot.springboot.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

interface LoginI {
    void login();
}

class UserLogin implements  LoginI{
    @Override
    public void login() {
        System.out.println("登录");
    }
}
class ProxyUser implements InvocationHandler{
    UserLogin userLogin;

    public ProxyUser(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前");
        userLogin.login();
        System.out.println("前");
        return "";
    }
}

public class JDKProxy {
    public static void main(String[] args) {
        UserLogin userLogin = new UserLogin();
        LoginI proxyInstance =(LoginI)Proxy.newProxyInstance(userLogin.getClass().getClassLoader(), new Class[]{LoginI.class}, new ProxyUser(userLogin));
        proxyInstance.login();
    }
}
