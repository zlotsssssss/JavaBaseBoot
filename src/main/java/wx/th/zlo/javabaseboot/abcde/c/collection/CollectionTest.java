package wx.th.zlo.javabaseboot.abcde.c.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;


//集合：看Collection接口
/*


 */
public class CollectionTest {
	
	private List<String> list;
	
	
	@Before
	public void before() {
		//Arrays的asList是Arrays内部的Arraylist，没有实现AbstractList中的removeIf方法，AbstractList默认抛出UnsupportedOperationException，
		//而java.util.ArrayList中的list实现了。
		list =  new ArrayList<String>(Arrays.asList("123","a123","b123"))  ;
	}
	
	@Test
	public void test() {
		list.removeIf(t -> t.contains("a"));
		list.removeIf(new Predicate<String>() {
			public boolean test(String t) {return t.contains("a");};
		});
		for( String s :list) {
			System.out.println(list);
		}
	}
}
