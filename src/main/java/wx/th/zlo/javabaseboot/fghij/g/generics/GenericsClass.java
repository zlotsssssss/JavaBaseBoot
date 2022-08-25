package wx.th.zlo.javabaseboot.fghij.g.generics;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
// 泛型类
/**
 * @author 周立瓯
 *
 */
public class GenericsClass {

		@Test
		public void genericsClass() {
			Object object = new Object();
			
			//new对象，没指明具体泛型类型，编译完成后，默认是引用类型中的泛型类型，下面默认是Fruit，
			ArrayList<Fruit> fruit1 = new ArrayList<>(Arrays.asList(new Fruit()));
			
			//编译、运行成功，Apple默认向上转型为Fruit
			ArrayList<Fruit> fruit2 = new ArrayList<>(Arrays.asList(new Apple()));
			
			//编译失败：cannot convert from ArrayList<Apple> to ArrayList<Fruit>,
			//ArrayList<Fruit> fruit3 = new ArrayList<Apple>(Arrays.asList(new Apple()));
			
		}
}
