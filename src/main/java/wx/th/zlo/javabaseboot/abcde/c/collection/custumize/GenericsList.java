package wx.th.zlo.javabaseboot.abcde.c.collection.custumize;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import wx.th.zlo.javabaseboot.aabase.Student;

/*
功能：自定义集合，实现list的toMap方法，传入keyMapper和valueMapper,决定返回的Map的key，value。
理解：提供给toMap方法，2个对k，v的构造器接口，方法体内调用2个构造器接口，分别得到k，v。
实现：定义接口Function<T,R>，提供一个apply方法，传入一个item，返回一个自定义的R类型数据，。
集合中的每一个元素调用这个接口，生成k，v。具体实现方式，传入结构实现类。
 */

interface Function<T,R>{
	R apply(T value);
}

class CustomList<T>{
	
	private T[] values;

	public CustomList(T[] values) {
		this.values = values;
	}
	
	public <K,V> Map<K,V> toMap(Function<T,K> keyMapper,Function<T,V> valueMapper){
		Map<K,V> map = new HashMap<K,V>();
		for(int i = 0 ; i < values.length ; i++) {
			K r = keyMapper.apply(values[i]);
			V v = valueMapper.apply(values[i]);
			map.put(r, v);
		}
		return map;
	}
}
public class GenericsList {
	@Test
	public void test() {
		Student[] students = {new Student("zlo","18","男"),new Student("sjg","19","女")};
		CustomList<Student> list = new CustomList<Student>(students);

		Map<String, HashMap<Object, Object>> map = list.toMap(item -> {
			return item.getName();
		}, item -> {
			HashMap<Object, Object> map1 = new HashMap<>();
			map1.put("age", item.getAge());
			map1.put("sex", item.getSex());
			return map1;
		});

		for (Map.Entry<String, HashMap<Object, Object>> entry : map.entrySet()) {
			String key = entry.getKey();
			HashMap<Object, Object> value = entry.getValue();
			System.out.println("key:" + key + " value:" + value);
		}


	}
}
