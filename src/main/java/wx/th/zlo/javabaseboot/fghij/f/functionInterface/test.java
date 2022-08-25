package wx.th.zlo.javabaseboot.fghij.f.functionInterface;
/*
:: 双冒号的实现：jdk8新特性，方法引用，简化lambda表达式。一个函数接口，可以用类::方法形式来初始化
 */

public class test {
	public static void main(String[] args) {
		IConvert<String, String>  con = Something::startsWith;//将Something中的静态方法，转化成实现了IConvert接口的实现类，和lambda一样
		IConvert<String, String>  con1 = new IConvert<String, String>() {
			@Override
			public String convert(String form) {
				return String.valueOf(form.charAt(0));
			}
		};
		String s = con1.convert("123");
		System.out.println(s);

	}

}
