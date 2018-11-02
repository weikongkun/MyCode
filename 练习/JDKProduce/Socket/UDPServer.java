package com.imooc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * �������ˣ�����UDP���û���¼
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		//1.������������DatagramSocket��ָ���˿�
		DatagramSocket socket = new DatagramSocket(8800);
		//2.�������ݱ������ڽ��տͻ��˷��͵����ݣ�
		byte[] data = new byte[1024];//�����ֽ����飬ָ�����յ����ݱ��Ĵ�С
		DatagramPacket packet = new DatagramPacket(data, data.length);
		//3.���տͻ��˷��͵�����
		System.out.println("*****************�������Ѿ����������ȴ��ͻ���******************");
		socket.receive(packet);//�˷����ڽ��յ����ݱ�֮ǰ����������
		//4.��ȡ����
		
		String info = new String(data, 0, packet.getLength());
		System.out.println("���Ƿ������ˣ�" + info);
		
		/*
		 * ��ͻ�����Ӧ����
		 */
		//1.����ͻ��˵ĵ�ַ���˿ںš�����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "��ӭ��".getBytes();
		//2.�������ݱ���������Ӧ������
		DatagramPacket packet2= new DatagramPacket(data2, data2.length, address, port);
		//3.��Ӧ�ͻ���
		socket.send(packet2);
		//4.�ر���Դ��Ϣ��
		socket.close();
	}
}
