package wx.th.zlo.javabaseboot.abcde.c.collection.custumize;

import wx.th.zlo.javabaseboot.aabase.Student;

import java.util.HashMap;
import java.util.Map;

interface Function1<T,R>{
    R apply(T t);
}
class CList<T>{
    T[] item;

    public CList(T[] item) {
        this.item = item;
    }

    public  <K,V> Map<K,V> toMap(Function1<T,K> keyMapper, Function1<T,V> valueMapper){
        HashMap<K, V> map = new HashMap<>();
        for (T t : item) {
            K k = keyMapper.apply(t);
            V v = valueMapper.apply(t);
            map.put(k,v);
        }
        return map;
    }
}

public class CustomizeList {
    public static void main(String[] args) {
        Student[] students = {new Student("zlo","18","男"),new Student("sjg","19","女")};
        CList<Student> cList = new CList<>(students);
        Map<String, String> stringStringMap = cList.toMap(item->item.getName(),item->item.getAge());
        System.out.println(stringStringMap);
    }
}
