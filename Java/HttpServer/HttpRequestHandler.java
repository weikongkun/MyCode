package com.htttpserver.server01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class HttpRequestHandler extends Thread {
	public static final String ROOT = "c:/";
	public InputStream input;
	public OutputStream output;
	public HttpRequestHandler(Socket socket) {
		try {
			input = socket.getInputStream();
			output = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		String filePath = read();
		response(filePath);
	}
	private void response(String filePath) {
		File file = new File(ROOT + filePath);
		if (file.exists()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line).append("\r\n");
				}
				StringBuffer result = new StringBuffer();
				result.append("HTTP /1.1 200 ok /r/n");
				result.append("Content-Type:text/html /r/n");
				result.append("Content-length:" + file.length() + "/r/n");
				result.append("\r\n:" + sb.toString());
				output.write(result.toString().getBytes());
				output.flush();
				output.close();
				reader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			StringBuffer error = new StringBuffer();
			error.append("HTTP /1.1 400 file not found /r/n");
			error.append("Content-Type:text/html;charset=utf-8 \r\n");
			error.append("Content-length:20\r\n").append("\r\n");
			error.append("<h1>File Not Found..</h1>");
			try {
				output.write(error.toString().getBytes());
				output.flush();
				output.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	private String read() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String readLine = reader.readLine();
			String[] split = readLine.split(" ");
			if (split.length != 3) return null;
			System.out.println(readLine);
			System.out.println(split[1]);
			return split[1];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
