package wx.th.zlo.javabaseboot.pqrst.s.serializeble;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 5875760287446429789L;
	// private static final long serialVersionUID = -5809782578272943999L;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int age;
	private String name;
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	
}
public class TestSerializable  {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dse();
		
		
	}
	public static  void Se() throws IOException {
		Person person = new Person();
		person.setAge(18);
		person.setName("zlo");
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("b.txt"));
		out.writeObject(person);
		System.out.println("���л��ɹ�");
		
	}
	public static void Dse() throws IOException, ClassNotFoundException{
		ObjectInputStream input=  new ObjectInputStream(new FileInputStream("b.txt"));
		Person person = (Person)input.readObject();
		System.out.println(person.toString());
		
	}

}

