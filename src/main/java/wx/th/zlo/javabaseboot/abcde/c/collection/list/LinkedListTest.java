package wx.th.zlo.javabaseboot.abcde.c.collection.list;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

// LinkedList特点:查询慢，增删快，不安全,实现了Deque接口
// 底层用内部类Node<T> 存储，就三个属性，T item，Node<T> prev,Node<T> next 3个属性
//	通过first保存第一个节点，last保存最后一个节点
// 特有：addFirst(),removeFirst(),getFirst(),addLast(),removeLast(),getLast(),
public class LinkedListTest {
	@Test
	public void test() {
		LinkedList<String> list = new LinkedList<String>();
		list.add(0,"1");
		list.add("2");
		String string = list.get(1);
		System.out.println(string);
	}
}
