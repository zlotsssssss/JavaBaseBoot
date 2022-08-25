package wx.th.zlo.javabaseboot.abcde.c.classdescriptor;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.springframework.beans.BeanUtils;

import wx.th.zlo.javabaseboot.aabase.Student;

public class ClassTest {
	public static void main(String[] args) throws Exception{
		//获得对类的表述类
		Class<Student> studentClass =Student.class;
		//通过 属性名和 方法名 获得类的属性和方法
		Field declaredField = studentClass.getDeclaredField("name");
		Method declaredMethod = studentClass.getDeclaredMethod("getName");
		Method getAge = studentClass.getDeclaredMethod("getAge");
		//通过BeanUtils 将对类的表述结构 转换成 一对象 包含了属性、属性的读写方法 这样的结构
		PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(studentClass);
		for (PropertyDescriptor pDescriptor : propertyDescriptors) {
			pDescriptor.getName();
			pDescriptor.getWriteMethod();
			pDescriptor.getReadMethod();
		}
	}
	//通过反射获得某个类的某属性描述对象，然后在获得这个类的属性值，可以获得私有和共有
	public int getArrayListCapaCity(ArrayList list) throws Exception{
	    //获取Class对象
	    Class c = Class.forName("java.util.ArrayList");
	    //映射Class对象c所表示类(即Arraylist)的属性
	    Field field = c.getDeclaredField("elementData");
	    //设置访问状态表示为true
	    field.setAccessible(true);//配置accessible 为真
	    //返回指定对象上此 Field 表示的字段的值
	    Object[] object = (Object[])field.get(list);
	    return object.length;
	}
}
