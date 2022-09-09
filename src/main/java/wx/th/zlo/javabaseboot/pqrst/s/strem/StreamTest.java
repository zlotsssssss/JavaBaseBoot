package wx.th.zlo.javabaseboot.pqrst.s.strem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class Dishf{
	int f;

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}
	
}


class Dish extends Dishf{
	String name;
	int price;
	int calories;

	public Dish(String name, int calories) {
		super();
		this.name = name;
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", price=" + price + ", calories=" + calories + "]";
	}

}

class Dish2 extends Dish{

	public Dish2(String name, int calories) {
		super(name, calories);
		// TODO Auto-generated constructor stub
	}
	private String zlo;
	public String getZlo() {
		return zlo;
	}
	public void setZlo(String zlo) {
		this.zlo = zlo;
	}
	
	
}
/*

Stream可以由数组或集合创建，对流的操作分为两种：
1.中间操作，每次返回一个新的流，可以有多个。（筛选filter、映射map、排序sorted、去重组合skip—limit）
2.终端操作，每个流只能进行一次终端操作，终端操作结束后流无法再次使用。终端操作会产生一个新的集合或值。
	（遍历foreach、匹配find–match、规约reduce、聚合max–min–count、收集collect）


流理解：把list转化成一条流，就是将每个元素按顺序串连起来。
对流操作api理解：
	操作api：对流进行过滤，投影，筛选等操作
	流还原成集合：List，map等

*/
public class StreamTest {
	
	public static void main(String[] args) {
		
		Dishf dishf = new Dishf();
		List<Dish> menu = Arrays.asList(new Dish("pork", 800), new Dish("beef", 700), new Dish("chicken", 400), new Dish("chicken123", 400),
				new Dish("french fries", 530), new Dish("rice", 350), new Dish("fruit", 120), new Dish("pizza", 550),new Dish2("zlo", 0)
				);

		
		//流过滤
		List<Dish> lowCaloriesDishName=menu.stream()
				.filter(d->d.getCalories()<400)
				.collect(Collectors.toList());
		for(Dish name:lowCaloriesDishName)
			System.out.println(name);
		
		menu.stream().filter(new Predicate<Dish>() {
			public boolean test(Dish t) {
				return t.getCalories() < 400;
			};
		}).collect(Collectors.toList());
		
		
		Optional<Dish> findAny = menu.stream().filter(t -> t.getCalories()<400).findAny();
		System.out.println(findAny.get());
		
		Optional<Dish> max = menu.stream().max((o1, o2) -> o1.getCalories()-o2.getCalories());
		Optional<Dish> max1 = menu.stream().max(Comparator.comparingInt(Dish::getCalories));
		System.out.println(max.get());
		System.out.println(max1.get());
		
		
		Optional<Integer> findFirst = menu.stream().map(t -> t.getCalories()).findFirst();
		System.out.println(findFirst.get());
		
	
		
		//分区，只能分成2个区，满足条件和不满足条件
		Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(t -> t.getCalories()>300));
		System.out.println(collect);
		
		//分组，按照某个属性值
		Map<Integer, List<Dish>> collect1 = menu.stream().collect(Collectors.groupingBy(t -> t.getCalories()));
		System.out.println(collect1);
		
		//排序
		List<Dish> collect2 = menu.stream().sorted(Comparator.comparing(Dish::getCalories)).collect(Collectors.toList());
		System.out.println(collect2);
		
		//将list 变成 map
		Map<String, Dish> map = menu.stream().collect(Collectors.toMap(new Function<Dish, String>() {
			public String apply(Dish t) { return t.getName();};
		}, new Function<Dish, Dish>() {
			public Dish apply(Dish t) { return t;};
		}));
		System.out.println("_________________________________________");
		System.out.println(map);
		
		Function<? super Dish, ? extends String> keyMapper =new Function<Dish, String>() {
			public String apply(Dish t) { return t.getName();};
		};
		
	}

}
