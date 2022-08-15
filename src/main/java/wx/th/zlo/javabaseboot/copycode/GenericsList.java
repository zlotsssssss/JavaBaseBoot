package wx.th.zlo.javabaseboot.copycode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;



interface Function<T,R>{
	R apply(T value);
}

class zloList<T>{
	
	private T[] values;

	public zloList(T[] values) {
		this.values = values;
	}
	
	public <R> Map<R,T> toMap(Function<T,R> keyMapper){
		Map<R,T> map = new HashMap<R,T>();
		for(int i = 0 ; i < values.length ; i++) {
			R r = keyMapper.apply(values[i]);
			map.put(r, values[i]);
		}
		return map;
	}
	
	
}




public class GenericsList {
	@Test
	public void test() {
		zloList<String> list = new zloList<String>(new String[] {"a1","b2","c3"});
		
		Map<Character, String> map = list.toMap(value -> value.charAt(0));
		
		for (Map.Entry<Character, String> entry : map.entrySet()) {
			Character key = entry.getKey();
			String val = entry.getValue();
			System.out.println("key:" + key + " value:" + val);
		}
	}
}
