package wx.th.zlo.javabaseboot.test1;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import wx.th.zlo.javabaseboot.fghij.j.jpa.Student;

public class AA {
	public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int  sum = 0;
        Iterator<Integer> iterator = binary.iterator();
        while(iterator.hasNext()) {
        	sum = sum*2 + iterator.next();
        }
        return sum;
    }
	public static int ConvertBinaryArrayToInt1(List<Integer> binary) {
		Optional<Integer> reduce = binary.stream().reduce((x, y) -> x * 2 + y);
		return reduce.get();
    }
	
	public static void main(String[] args) {
		//System.out.println(ConvertBinaryArrayToInt1(Arrays.asList(1,1,0,1)));
		Student student = new Student("zlo","nan","18");
		Optional<Student> opt = Optional.of(student);
		System.out.println(opt);
	}
}
