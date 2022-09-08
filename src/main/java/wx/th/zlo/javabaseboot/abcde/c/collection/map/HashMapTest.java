package wx.th.zlo.javabaseboot.abcde.c.collection.map;

import org.junit.Test;
import wx.th.zlo.javabaseboot.fghij.g.generics.Fruit;

import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


//HashMap 底层用Node<K,V>[] tables 存储数据，一个node，包含hash、k、v、next(用与存储相同hash的对象)，底层还是数组
/*运行原理:
            1.put,先根据key计算出hash，然后将Node<k,v>存到tables[hash]位置上，如果有相同hash且调用equal相等，则会覆盖，
                其他情况就会存到Node<k,v>.next
            2.get,根据key和hash，拿到tables里面的元素
  思想：Set<String> keySet = map.keySet(); 关于map.keySet()返回是set的理解：返回的数据类型是key，在逻辑上是不能重复的，且没有顺序可言，
  所以用Set集合最为合适。
  对Set，List，Map的理解：他们本身不包含任何的元素，只是对一些特定结构，总结出了相同之处和相同的操作（结构和方法），不要去在意
  他们是不同内部元素，在抽象类中他们还没确定内部元素是什么。

 */
//HashMap测试
public class HashMapTest {
    @Test
    public void test() throws Exception {
        Map<String, Fruit> map = new HashMap<>();
        map.put("banana", new Fruit("banana", "19"));
        map.put("apple", new Fruit("apple", "19"));
        map.put("dddd", new Fruit("apple", "19"));
        map.put("applecc", new Fruit("apple", "19"));
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s);
        }

        Map.Entry<String, Fruit>[] objec = getArrayListCapaCity(map);
        for (int i = 0; i < objec.length; i++) {
            if(objec[i] != null)
                System.out.println(objec[i].getValue() + " " +i);
        }
        System.out.println(objec.length);
        Set<Map.Entry<String, Fruit>> entries = map.entrySet();
    }

    public Map.Entry<String, Fruit>[] getArrayListCapaCity(Map<String, Fruit> map) throws Exception {
        //获取Class对象
        Class c = Class.forName("java.util.HashMap");
        //映射Class对象c所表示类(即Arraylist)的属性
        Field field = c.getDeclaredField("table");
        //设置访问状态表示为true
        field.setAccessible(true);
        //返回指定对象上此 Field 表示的字段的值
        Map.Entry<String, Fruit>[] object = (Map.Entry<String, Fruit>[]) field.get(map);
        return object;
    }
}
