package wx.th.zlo.javabaseboot.fghij.g.generics;

//父类:水果类
public class Fruit {
	
	private String name;
	
	private String price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Fruit(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Fruit() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", price=" + price + "]";
	}
	
	
}
