package wx.th.zlo.javabaseboot.aabase.algorithm;

import java.util.ArrayList;
/*
用{"3","32","321"},组合出最小数字
思想：谁排在前面，根据A+B、B+A的比较来决定
 */

public class Testr {
    public static void main(String[] args) {
        String[] arr = {"3","32","321"};
        ArrayList<String> list = new ArrayList<>();
        for (String s : arr) {
            list.add(s);
        }
        list.sort((o1,o2)->{
            String s1 =(o1+o2);
            String s2 =  (o2+o1);
            return  s1.compareTo(s2) ;
        });
        for (String s : list) {
            System.out.println(s);
        }
    }
}
