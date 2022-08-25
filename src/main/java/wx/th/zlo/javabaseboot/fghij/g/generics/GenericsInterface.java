package wx.th.zlo.javabaseboot.fghij.g.generics;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

// 泛型接口案例:有待完善，猜测：定义好一个泛型接口时候，只有在写实现类的时候，才确定参数类型。
// 目前了解到的就是用于匿名内部类。
// 案例说明：定义了一个泛型接口Function，用于用户实现自定义函数体。

//函数接口:用于规范一个函数对象的 定义 和使用，
interface Function<T,R>{
	R apply(T value);
}

//自定义list集合
class GenericsList<T>{
	
	private T[] obj;
	
	public GenericsList(T[] obj) {
		super();
		this.obj = obj;
	}
	
	//将集合 转化成 map，map的key自定义决定，通过传入一个函数接口来实现，
	//该接口函数应该提供一个规定的接口方法用于返回key，具体实现由程序员自己写，如下apply方法可自定义。
	public <R> Map<R,T> toMap(Function<? super T,? super R> keepMaper)throws Exception{
		Map<R,T> map = new HashMap<R,T>();
		for (int i =0 ; i < obj.length ; i++ ) {
			R r =(R) keepMaper.apply(obj[i]);
			map.put(r, obj[i]);
		}
		return map;
	}
}

public class GenericsInterface {
	
	@Test
	public void test() throws Exception{
//		//字符串例子
//		GenericsList<String> genericsList = new GenericsList<String>(new String[] {"a1","b2","c3"});
//		
//		//使用匿名内部类
//		Map<Character, String> map = genericsList.toMap(new Function<String,Character>() {
//			@Override
//			public Character apply(String value) {
//				// TODO Auto-generated method stub
//				return value.charAt(0);
//			}
//		});
//		
//		//lambda 表达式
//		//Map<Character, String> map = genericsList.toMap(value -> value.charAt(0));
//		for (Map.Entry<Character, String> entry : map.entrySet()) {
//			Character key = entry.getKey();
//			String val = entry.getValue();
//			System.out.println("key:"+key+" value:"+val);
//		}
		
		//获得水果名字和水果的映射,便于直接通过水果名字找到水果
		Fruit[] f = {new Fruit("apple","100"),new Fruit("banana","50")};
		GenericsList<Fruit> genericsList = new GenericsList<>(f);
		Map<String, Fruit> map = genericsList.toMap(value -> value.getName());
		for (Map.Entry<String, Fruit> entry : map.entrySet()) {
			String key = entry.getKey();
			Fruit val = entry.getValue();
			System.out.println("key:" + key + " value:" + val);
		}
		
	}
}
