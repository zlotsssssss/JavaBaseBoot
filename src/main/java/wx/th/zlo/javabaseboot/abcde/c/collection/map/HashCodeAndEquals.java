package wx.th.zlo.javabaseboot.abcde.c.collection.map;

//测试：当2个对象的hashcode 和 equals 都相等， map插入就会覆盖

import java.util.HashMap;

class Inte {
    int value;

    public Inte(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return value % 3;
    }

    @Override
    public boolean equals(Object obj) {
        return value % 2 == 0;
    }
}



public class HashCodeAndEquals {
    public static void main(String[] args) {
        Inte inte1 = new Inte(8);
        Inte inte2 = new Inte(4);
        HashMap<Inte, String> map = new HashMap<>();
        map.put(inte1,"1");
        map.put(inte2,"2");

        for (Inte inte : map.keySet()) {
            String s = map.get(inte);
            System.out.println(s);
        }
    }
}
