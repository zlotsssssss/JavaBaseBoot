AOP:Aspect Oriented Programming 面向切面编程。 作用：将业务逻辑的各个部分分离，降低业务逻辑各个各个部分的耦合度，提高程序的可重用性

代理方式：   
    1.有接口，JDK代理，创建接口实现类代理对象，增强类的方法,内置JDK中，无需引用三方库，使用简单，但功能比较弱
    2.无接口，CGLIB代理，创建子类代理对象,CGLIB：是高级的字节码生成库，性能比JDK的要好，并且功能强大
CGLIB代理是Code Generation Library

