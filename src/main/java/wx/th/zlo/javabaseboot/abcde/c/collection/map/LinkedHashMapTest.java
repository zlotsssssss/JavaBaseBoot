package wx.th.zlo.javabaseboot.abcde.c.collection.map;

import wx.th.zlo.javabaseboot.fghij.g.generics.Fruit;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


/*
LinkedHashMap 继承 HashMap 重写底层数据，带有顺序
static class Entry<K,V> extends HashMap.Node<K,V> {
    LinkedHashMap.Entry<K,V> before, after;
    Entry(int hash, K key, V value, HashMap.Node<K,V> next) {
        super(hash, key, value, next);
    }
}*/


public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String, Fruit> map = new LinkedHashMap<>();
        map.put("banana", new Fruit("banana", "19"));
        map.put("apple", new Fruit("apple", "19"));
        map.put("dddd", new Fruit("apple", "19"));
        map.put("applecc", new Fruit("apple", "19"));
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s);
        }
    }
}
