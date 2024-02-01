package com.kh.example1.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.example1.practice2.compare.ArtistDescending;
import com.kh.example1.practice2.compare.TitleAscending;
import com.kh.example1.practice2.controller.SongController2;
import com.kh.example1.practice2.model.Song2;

public class Application2 {
	
	private Scanner sc = new Scanner(System.in);
	private SongController2 control = SongController2.getInstance();

	public static void main(String[] args) {
		Application2 app2 = new Application2();
		app2.mainMenu();
	}
	
	public void mainMenu() {
		try {
			
			boolean check = true;
			while(check) {
				System.out.println("===== 메인 메뉴 =====");
				System.out.println("1. 마지막 위치에 곡 추가");
				System.out.println("2. 첫 위치에 곡 추가");
				System.out.println("3. 전체 곡 목록 출력");
				System.out.println("4. 특정 곡 검색");
				System.out.println("5. 특정 곡 삭제");
				System.out.println("6. 특정 곡 수정");
				System.out.println("7. 곡 명 오름차순 정렬");
				System.out.println("8. 가수 명 내리차순 정렬");
				System.out.println("9. 종료");
				System.out.print("메뉴 번호 입력 : ");
				int menu = Integer.parseInt(sc.nextLine());
				
				switch(menu) {
					case 1:
						addLastList();
						break;
					case 2:
						addFirstList();
						break;
					case 3:
						printAll();
						break;
					case 4:
						searchSong();
						break;
					case 5:
						removeSong();
						break;
					case 6:
						updateSong();
						break;
					case 7:
						ascTitle();
						break;
					case 8:
						descArtist();
						break;
					case 9:
						System.out.println("프로그램을 종료합니다.");
						check = false;
						break;
					}
			}
			
			
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다." + e.getMessage());
			mainMenu();
		}
	}
	
	// 1. 마지막 위치에 곡 추가
	public void addLastList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String artist = sc.nextLine();
		
		Song2 song = new Song2(title, artist);
		boolean result = control.addLastList(song);
		if(result) {
			System.out.println("추가 성공!");
		} else {
			System.out.println("!! 정보를 제대로 입력해주세요 !!");
		} 
	}
	
	
	// 2. 첫 위치에 곡 추가
	public void addFirstList() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String artist = sc.nextLine();
		
		Song2 song = new Song2(title, artist);
		boolean result = control.addFirstList(song);
		if(result) {
			System.out.println("추가 성공!");
		} else {
			System.out.println("!! 정보를 제대로 입력해주세요 !!");
		}
	}
	
	// 3. 전체 곡 목록 출력
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		for(Song2 song : control.printAll()) {
			System.out.println(song);
		}
	}
	
	// 4. 특정 곡 검색
	public void searchSong() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		
		Song2 song = control.searchSong(title);
		if(song != null) {
			System.out.println(song + " 을 검색 했습니다.");
		} else {
			System.out.println("검색할 곡을 찾지 못했습니다.");
		}
	}

	// 5. 특정 곡 삭제
	public void removeSong() {
		
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		
		control.removeSong(title);
		Song2 song = control.removeSong(title);
		if(song != null) {
			System.out.println(song + " 을 삭제 했습니다.");
		} else {
			System.out.println("삭제할 곡이 없습니다.");
		}
	}
	
	// 6. 특정 곡 수정
	public void updateSong() {
		System.out.println("****** 특정 곡 수정 ******");
		System.out.print("검색할 곡 명 : ");
		String search = sc.nextLine();
		
		System.out.print("수정할 곡 명 : ");
		String title = sc.nextLine();
		
		System.out.print("수정할 가수 명 : ");
		String artist = sc.nextLine();
		
		Song2 update = new Song2(title, artist);
		Song2 song = control.updateSong(search, update);
		if(song != null) {
			System.out.println(song + "의 값이 변경되었습니다.");
		} else {
			System.out.println("수정할 곡을 찾지 못했습니다.");
		}
		

	}
	
	// 7. 곡 명 오름차순 정렬
	// 원래 리스트는 건들지 않기 위해 깊은 복사로 새로운 배열을 만들어 정렬 후 출력한다
	public void ascTitle() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");

		for(Song2 song : control.ascTitle()) {
			System.out.println(song);
		}
	}
	
	// 8. 가수 명 내림차순 정렬
	public void descArtist() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");

		for(Song2 song : control.descArtist()) {
			System.out.println(song);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}




