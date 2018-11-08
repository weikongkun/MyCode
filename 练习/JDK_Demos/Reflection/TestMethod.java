package com.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethod {
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("com.Reflection.B");
			//�����޲κ���
			Method[] methods = clazz.getDeclaredMethods();
			B b = (B) clazz.newInstance();
//			for (Method method : methods) {
//				method.setAccessible(true);
//				method.invoke(b);
//			}
			
			//�����вκ���
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
		System.out.println("�вι��캯��" + i + j);
	}
	// ˽�о�̬����
	private static void PrivateStaticMethod() {
		System.out.println("˽�о�̬����ִ��");
	}

	// ���о�̬����
	public static void PublicStaticMethod() {
		System.out.println("���о�̬����ִ��");
	}

	// ˽�з���
	private void PrivateMethod() {
		System.out.println("˽�з���ִ��");
	}

	// ���з���
	public static void PublicMethod() {
		System.out.println("���з���ִ��");
	}
	//�����вη���
	public void PublicArgsMethod(int i, int j) {
		System.out.println("�����вη���ִ��" + i + j);
	}
}
