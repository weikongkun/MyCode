package com.imooc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
/*
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 */
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) {
		
		try {
			//1.����һ����������Socket����ServerSocket���ƶ��󶨵Ķ˿ڣ�������
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			int count = 0;
			System.out.println("***�����������������ȴ��ͻ��˵�����***");
			while (true) {
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				Thread thread = new Thread(serverThread);
				thread.start();
				count++;
				thread.sleep(2000);
				System.out.println("�ͻ��˵�����Ϊ��" + count );
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
