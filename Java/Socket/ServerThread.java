package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ���������̴߳�����
 */
public class ServerThread implements Runnable {
	//�ͱ��߳���ص�Socket
	Socket socket = null;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	//�߳�ִ�еĲ�������Ӧ�ͻ��˵�����
	
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		
		try {
			
			is = socket.getInputStream();//�ֽ�������
			isr = new InputStreamReader(is);//���ֽ���ת��Ϊ�ַ���
			br = new BufferedReader(isr);//��ӻ���
			
			String info = null;
			
			while ((info = br.readLine()) != null) {//ѭ����ȡ�ͻ��˵���Ϣ
				System.out.println("���Ƿ��������ͻ���˵��" + info);
			}
			
			socket.shutdownInput();//�ر�������
			//��ȡ���������Ӧ�ͻ��˵�����
			os = socket.getOutputStream();//�ֽ������
			pw = new PrintWriter(os);//��װΪ��ӡ��
			pw.write("��ӭ����");
			pw.flush();//����flush()�������������
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//�ر���Դ
			try {
				if (pw != null)
					pw.close();
				if (os != null)
					os.close();
				if (br != null)
					br.close();
				if (isr != null)
					isr.close();
				if (is != null)
					is.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
	}
}
