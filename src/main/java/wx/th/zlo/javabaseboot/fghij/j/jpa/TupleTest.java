package wx.th.zlo.javabaseboot.fghij.j.jpa;


import javax.persistence.Tuple;

import org.hibernate.jpa.spi.NativeQueryTupleTransformer;
/**
 * 		功能：Tuple类型转化成任意类，
 * 		Tuple类：用Map<key,value>存储 字段和字段值
 * 		
 * 
 * 
 * 
 * 
 * */

public class TupleTest {
	public static void main(String[] args) throws Exception, SecurityException, NoSuchMethodException {
	
		
		//new 一个 Tuple类型
		NativeQueryTupleTransformer tupleTransformer = new NativeQueryTupleTransformer();
		Object[] obj = new String[] {"1","2","3"};
		String[] alias = new String[] {"name","sex","age"};
		Tuple tuple = (Tuple)tupleTransformer.transformTuple(obj, alias);
		
		Student student = NativeResultProcessUtils.processResult(tuple, Student.class);
		System.out.println(student);
		
	}
}
