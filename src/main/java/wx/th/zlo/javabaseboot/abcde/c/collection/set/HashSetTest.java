package wx.th.zlo.javabaseboot.abcde.c.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

//
public class HashSetTest {
    @Test
    public  void  test(){
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
