package wx.th.zlo.javabaseboot.abcde.c.collection.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

// Arraylist特点：
// 底层数组实现，随机访问，不同步，不安全
// 用Object[] 存储数据
// 调用ArrayList无参构造函数，第一次扩容10,以后每次都扩容原容量的1.5倍,扩容通过位运算右移动1位
public class ArrayListTest {
	
	public int getArrayListCapaCity(ArrayList list) throws Exception{
	    //获取Class对象
	    Class c = Class.forName("java.util.ArrayList");
	    //映射Class对象c所表示类(即Arraylist)的属性
	    Field field = c.getDeclaredField("elementData");
	    //设置访问状态表示为true
	    field.setAccessible(true);
	    //返回指定对象上此 Field 表示的字段的值
	    Object[] object = (Object[])field.get(list);
	    return object.length;
	}

	
	@Test
	public void test() throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		for(int i = 0 ; i < 16 ; i++) {
			list.add(i);
			System.out.println(getArrayListCapaCity(list));
		}



	}
	
}
