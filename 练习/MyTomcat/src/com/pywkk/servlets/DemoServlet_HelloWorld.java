package com.pywkk.servlets;

import java.io.IOException;

import com.pywkk.MyServlet;
import com.pywkk.server.MyRequest;
import com.pywkk.server.MyResponse;

public class DemoServlet_HelloWorld extends MyServlet {

	@Override
	public void doGet(MyRequest myRequest, MyResponse myResponse) {
		try {
			myResponse.write("DemoServlet_HelloWorld get method......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(MyRequest myRequest, MyResponse myResponse) {
		try {
			myResponse.write("DemoServlet_HelloWorld post method......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
