package wx.th.zlo.javabaseboot.abcde.c.collection.set;

import java.util.LinkedHashSet;

/*
    LinkedHashSet：底层采用数据结构，哈希表和双向链表。输入，输出有顺序
    底层实现：LinkedHashMap实现

 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("1");
        linkedHashSet.add("2");
        linkedHashSet.add("3");
        linkedHashSet.add("4");
        linkedHashSet.add("6");
        linkedHashSet.add("5");
        for (String s : linkedHashSet) {
            System.out.println(s);
        }
    }
}
