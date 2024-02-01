package com.kh.socket3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattServer {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(3000); // 서버소켓은 포트번호가 필요
			System.out.println("클라이언트 기다리는 중...!");
			
			while(true) {
				Socket socket = serverSocket.accept();
				// 클라이언트가 여러명 이니까 접속할 때마다 새로운 스레드 새성
				ClientThread client = new ClientThread(socket);
				client.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
