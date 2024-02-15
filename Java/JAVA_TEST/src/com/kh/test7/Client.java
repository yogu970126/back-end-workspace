package com.kh.test7;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			Socket s = new Socket(ip, 3000);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		}
	}

}
