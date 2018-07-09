package com.imooc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * 服务器端，基于UDP的用户登录
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		//1.创建服务器端DatagramSocket，指定端口
		DatagramSocket socket = new DatagramSocket(8800);
		//2.创建数据报，用于接收客户端发送的数据；
		byte[] data = new byte[1024];//创建字节数组，指定接收的数据报的大小
		DatagramPacket packet = new DatagramPacket(data, data.length);
		//3.接收客户端发送的数据
		System.out.println("*****************服务器已经被启动，等待客户端******************");
		socket.receive(packet);//此方法在接收到数据报之前会抑制阻塞
		//4.读取数据
		
		String info = new String(data, 0, packet.getLength());
		System.out.println("我是服务器端：" + info);
		
		/*
		 * 向客户端响应数据
		 */
		//1.定义客户端的地址、端口号、数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "欢迎你".getBytes();
		//2.创建数据报，包含响应的数据
		DatagramPacket packet2= new DatagramPacket(data2, data2.length, address, port);
		//3.响应客户端
		socket.send(packet2);
		//4.关闭资源信息；
		socket.close();
	}
}
