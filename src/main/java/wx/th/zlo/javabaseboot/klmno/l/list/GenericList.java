package wx.th.zlo.javabaseboot.klmno.l.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/*
	当泛型类的类型声明中使用了通配符的时候， 其子类型可以在两个维度上分别展开,泛型类本身和通配符类型。如对 Collection<? extends Number> 来说，
	其子类型可以在 Collection 这个维度上展开，即 List<? extends Number> 和 Set<? extends Number> 等；
	也可以在 Number 这个层次上展开，即 Collection<Double> 和 Collection<Integer> 等。
	如此循环下去，ArrayList<Long> 和 HashSet<Double> 等也都算是 Collection<? extends Number> 的子类型。
*/


public class GenericList {
	public static void main(String[] args) {
		//？通配符，extends限定上界，nList能接受Number和它的子类
//		List<? extends Number > nList = new ArrayList<Number>();
		//新建一个list，参数是Number的子类
		List<Integer> iList = new ArrayList<Integer>();
		iList.add(1);
		iList.add(2);
		List<? extends Number > nList = iList;
		for (Number num : nList) {
			System.out.println(num);
		}
		
		//？通配符，super限定下界，sList能接受String和它的父类
		//List<? super String> sList = new ArrayList<String>();
		List<Object> oList = new ArrayList<Object>();
		oList.add((Object)1);
		List<? super String> sList=oList;
		Object object = sList.get(0);
		System.out.println(object);
		
	
		
	}
	
}
