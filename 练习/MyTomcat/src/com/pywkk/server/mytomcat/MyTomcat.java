package com.pywkk.server.mytomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.pywkk.MyServlet;
import com.pywkk.config.ServletMapping;
import com.pywkk.config.ServletMappingConfig;
import com.pywkk.server.MyRequest;
import com.pywkk.server.MyResponse;

public class MyTomcat {
	private int port = 8080;
	private Map<String, String> urlServlet = new HashMap<>();
	
	public MyTomcat(int port) {
		this.port = port;
	}
	
	public MyTomcat() {
	}
	
	public void start() {
		initServletMapping();
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("MyTomcat is start......");
			while(true) {
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				MyRequest myRequest = new MyRequest(inputStream);
				MyResponse myResponse = new MyResponse(outputStream);
				dispatch(myRequest, myResponse);
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
			
	}
	private void dispatch(MyRequest myRequest, MyResponse myResponse) {
		String clazz = urlServlet.get(myRequest.getUrl());
		try {
			Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
			MyServlet myServlet = myServletClass.newInstance();
 			myServlet.service(myRequest, myResponse);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private void initServletMapping() {
		for (ServletMapping servletMapping : ServletMappingConfig.servletMappingList)
			urlServlet.put(servletMapping.getUrl(), servletMapping.getClazz());
	}
	public static void main(String[] args) {
		new MyTomcat(8080).start();
	}
}
