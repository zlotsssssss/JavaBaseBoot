package wx.th.zlo.javabaseboot.klmno.o.optional;

/*
1. 创建：

    Optional.empty()： 创建一个空的 Optional 实例

    Optional.of(T t)：创建一个 Optional 实例，当 t为null时抛出异常

    Optional.ofNullable(T t)：创建一个 Optional 实例，但当 t为null时不会抛出异常，而是返回一个空的实例

2. 获取：

    get()：获取optional实例中的对象，当optional 容器为空时报错

3. 判断：

    isPresent()：判断optional是否为空，如果空则返回false，否则返回true

    ifPresent(Consumer c)：如果optional不为空，则将optional中的对象传给Comsumer函数

    orElse(T other)：如果optional不为空，则返回optional中的对象；如果为null，则返回 other 这个默认值

    orElseGet(Supplier<T> other)：如果optional不为空，则返回optional中的对象；如果为null，则使用Supplier函数生成默认值other

    orElseThrow(Supplier<X> exception)：如果optional不为空，则返回optional中的对象；如果为null，则抛出Supplier函数生成的异常

4. 过滤：

    filter(Predicate<T> p)：如果optional不为空，则执行断言函数p，如果p的结果为true，则返回原本的optional，否则返回空的optional

5. 映射：

    map(Function<T, U> mapper)：如果optional不为空，则将optional中的对象 t 映射成另外一个对象 u，并将 u 存放到一个新的optional容器中。

    flatMap(Function< T,Optional<U>> mapper)：跟上面一样，在optional不为空的情况下，将对象t映射成另外一个optional

    区别：map会自动将u放到optional中，而flatMap则需要手动给u创建一个optional

 */


import wx.th.zlo.javabaseboot.aabase.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Test {
    public static List<Student> initData(){
        return new ArrayList<Student>(Arrays.asList(new Student("zlo","18","男"),
                new Student("sjg",null,"女")));
    }
    public static void main(String[] args) {
        List<Student> studentList = initData();
        for (Student student : studentList) {
            //常见使用当 某个变量可能为空，设置默认值
            System.out.println(Optional.ofNullable(student.getAge()).orElse("男"));

        }
    }
}
