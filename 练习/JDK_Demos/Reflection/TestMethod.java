package com.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethod {
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("com.Reflection.B");
			//测试无参函数
			Method[] methods = clazz.getDeclaredMethods();
			B b = (B) clazz.newInstance();
//			for (Method method : methods) {
//				method.setAccessible(true);
//				method.invoke(b);
//			}
			
			//测试有参函数
			Class[] arg = {int.class, int.class};
			Method m = clazz.getMethod("PublicArgsMethod", arg);
			m.invoke(b, new Object[] {new Integer(1), new Integer(2)});
			
			Constructor con = clazz.getDeclaredConstructor(new Class[] {int.class, int.class});
			con.setAccessible(true);
			Object o = con.newInstance(new Integer[] {new Integer(21), new Integer(34)});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}

class B {
	public B() {
		
	}
	private B(int i, int j) {
		System.out.println("有参构造函数" + i + j);
	}
	// 私有静态方法
	private static void PrivateStaticMethod() {
		System.out.println("私有静态方法执行");
	}

	// 公有静态方法
	public static void PublicStaticMethod() {
		System.out.println("公有静态方法执行");
	}

	// 私有方法
	private void PrivateMethod() {
		System.out.println("私有方法执行");
	}

	// 公有方法
	public static void PublicMethod() {
		System.out.println("公有方法执行");
	}
	//公有有参方法
	public void PublicArgsMethod(int i, int j) {
		System.out.println("公有有参方法执行" + i + j);
	}
}
