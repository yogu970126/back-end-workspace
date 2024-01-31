package com.kh.socket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.Socket;



/*
 * 클라이언트 측 로직
 * 1. 소켓 생성
 * 2. 스트림
 * 
 * */
public class ChattClient {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getLocalHost();
			// 1. 소켓 생성
			Socket s2 = new Socket(ip.getHostAddress(), 60000);
			System.out.println("Client2 Socket Creating..");
			
			// 스트림
			// 키보드로 입력받은 데이터를 읽어서 서버로 보낸다
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(s2.getOutputStream(), true);
			
			System.out.println("Client2 Socket Creating...");
			
			// 다시 서버가 보낸 메세지를 받아서 클라이언트 자신의 콘솔창에 출력
			BufferedReader br2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));
			
			while(true) {
				String line = br.readLine();
				pw.println(line);
				
				String serverMsg = br2.readLine();
				System.out.println("내가 보낸 메세지 : " + serverMsg);
			}
			
		} catch(Exception e) {
			System.out.println("서버와의 연결에 실패했습니다.");
		}
	}

}
