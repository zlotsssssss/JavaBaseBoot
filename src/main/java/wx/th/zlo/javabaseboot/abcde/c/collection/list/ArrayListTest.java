package wx.th.zlo.javabaseboot.abcde.c.collection.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
		list.add(2);
		//list.add(3);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		//list1.add(1);
		list1.add(2);
		boolean b = list.retainAll(list1); //保留了List包含在lsit1中的元素，返回值表示是否
		System.out.println(b);
		System.out.println(list);


		//sort函数
		List<String> sortList = new ArrayList<>();
		sortList.add("3");
		sortList.add("1");
		sortList.add("2");
		sortList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int ret = 0;
				if( Integer.parseInt(o1) > Integer.parseInt(o2)){
					ret  = 1;
				}else{
					ret = -1;
				}
				return ret;
			}
		});
		for (String s : sortList) {
			System.out.println(s);
		}
	}
	
}
