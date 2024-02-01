package com.kh.socket3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChattClient {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("192.168.10.51", 3000); // 소켓에는 ip주소와 포트번호를 같이 매개변수로 넘긴다
			System.out.println("서버와 연결되었습니다..");
			
			Thread sendThread = new SendThread(socket);
			sendThread.start();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(br != null) {
				System.out.println(br.readLine());
			}
			
		} catch (IOException e) {
			System.out.println("서버 종료...!");
		} 
		
	}

}
