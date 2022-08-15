package wx.th.zlo.javabaseboot.FunctionalInterface;

public class test {
	public static void main(String[] args) {
		IConvert<String, String>  con = Something::startsWith;
		String s = con.convert("123");
		System.out.println(s);
	}

}
