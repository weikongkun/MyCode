package com.htttpserver.server01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	public void startServer(int port) {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				new HttpRequestHandler(socket).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
