package com.Reflection;

import java.lang.reflect.Field;

public class TestPrivateField {
	public static void main(String[] args) {
		Class<?> clazz;
		try {
			clazz = Class.forName("com.Reflection.A");
			A a = (A) clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				//私有属性设置为可以访问的
				field.setAccessible(true);
				System.out.println("设置属性前：" + field.getName() + "====" + field.get(a));
				//设置属性
				field.set(a, 123);
				System.out.println("设置属性后：" + field.getName() + "====" + field.get(a));
			}
			Field f = clazz.getDeclaredField("num");
			f.setAccessible(true);
			f.set(null, 3345);
			System.out.println(f.get(null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
class A {
	private int a1;
	private int a2;
	private static int num = 7;
}
