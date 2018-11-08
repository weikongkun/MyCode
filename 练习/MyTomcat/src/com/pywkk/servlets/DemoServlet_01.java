package com.pywkk.servlets;

import java.io.IOException;

import com.pywkk.MyServlet;
import com.pywkk.server.MyRequest;
import com.pywkk.server.MyResponse;

public class DemoServlet_01 extends MyServlet {

	@Override
	public void doGet(MyRequest myRequest, MyResponse myResponse) {
		try {
			myResponse.write("DemoServlet_01 get method......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void doPost(MyRequest myRequest, MyResponse myResponse) {
		try {
			myResponse.write("DemoServlet_01 post method......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
