package wx.th.zlo.javabaseboot.fghij.g.generics;

//子类：苹果
class Apple extends Fruit{
	
	public Apple() {
		super();
	}
	
	public Apple(String size) {
		super();
		this.size = size;
	}

	private String size ;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}