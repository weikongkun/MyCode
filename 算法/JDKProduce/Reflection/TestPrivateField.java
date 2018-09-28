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
				//˽����������Ϊ���Է��ʵ�
				field.setAccessible(true);
				System.out.println("��������ǰ��" + field.getName() + "====" + field.get(a));
				//��������
				field.set(a, 123);
				System.out.println("�������Ժ�" + field.getName() + "====" + field.get(a));
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
