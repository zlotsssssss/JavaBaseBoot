package wx.th.zlo.javabaseboot.fghij.g.generics;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 * JDK5新特性
 * 泛型的本质是参数化类型，即给类型指定一个参数，然后在使用时再指定此参数具体的值，那样这个类型就可以在使用时决定了。
 * 这种参数类型可以用在类、接口和方法中，分别被称为泛型类、泛型接口、泛型方法
 */

public class GenericsTest {
	
	//前提知识
	@Test
	public void prepare() {
		//不使用泛型，将可以插入所有类型的参数，
		ArrayList list = new ArrayList();
		list.add("123");
		list.add(123);
		// 业务逻辑操作：将元素去掉首字符，
		// 缺点1：以下代码会报错，由于之前插入类型不对的元素，整型123
		for (Object object : list) {
			//缺点2：因为不使用泛型，所以每个对象的存储都是Object，使用的时候需要转化
			String s = (String)object;
			System.out.println(s.substring(1));
		}
	}
	
	//使用泛型优势
	@Test
	public void advantage() {
		//规定了参数类型，
		ArrayList<String> list = new ArrayList<String>();
		//编译报错，list.add(123);优势1：保证了类型的安全性
		//只能添加泛型参数类型的对象、子类（自动向上转型）
		list.add("123");
		//优势2:不需要强转
		String string = list.get(0);
	}
	
	
	
	
	
	
}
