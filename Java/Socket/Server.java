package com.imooc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
/*
 * 基于TCP协议的Socket通信，实现用户登录
 */
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) {
		
		try {
			//1.创建一个服务器端Socket，即ServerSocket；制定绑定的端口，并侦听
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			int count = 0;
			System.out.println("***服务器即将启动，等待客户端的连接***");
			while (true) {
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				Thread thread = new Thread(serverThread);
				thread.start();
				count++;
				thread.sleep(2000);
				System.out.println("客户端的数量为：" + count );
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
