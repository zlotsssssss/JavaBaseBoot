package wx.th.zlo.javabaseboot.abcde.c.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

//底层实现HashMap实现 map<E,obj>,无顺序，直接根据值的hashcode，拿到值
public class HashSetTest {
    @Test
    public  void  test(){
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("6");
        set.add("5");
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
