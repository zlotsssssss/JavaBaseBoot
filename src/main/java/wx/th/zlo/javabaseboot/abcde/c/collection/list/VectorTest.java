package wx.th.zlo.javabaseboot.abcde.c.collection.list;

import java.util.Vector;

import org.junit.Test;

// Vector底层数组实现，：效率低，线程安全，查询快，增删慢

public class VectorTest {
	@Test
	public void test() {
		Vector<String> vector = new Vector<String>();
		vector.addElement(null);
		String item = vector.get(0);
		System.out.println(item);
	}
}
