package com.kh.example1.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.kh.example1.practice2.controller.MusicController;
import com.kh.example1.practice2.model.Song;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	List<Song> songList = new ArrayList<>();
	MusicController mc = new MusicController();

	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();		
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
			System.out.println("8. 가수 명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:
				addMusicLastPlace();
				break;
			case 2:
				addMusicFirstPlace();
				break;
			case 3:
				showMusicList();
				break;
			case 4:
				searchMusic();
				break;
			case 5:
				deleteMusic();
				break;
			case 6:
				updateMusic();
				break;
			case 7:
				ascendSortByTitle();
				break;
			case 8:
				descendSortBySinger();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				check = false;
				break;
				}
			}
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다 : " + e.getMessage());
			System.out.println();
			mainMenu();
		}
	}
	
	// 1. 마지막 위치에 곡 추가
	public void addMusicLastPlace() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		songList.add(new Song(title, singer));
		System.out.println("추가 성공");		
	}
	
	// 2. 첫 위치에 곡 추가
	public void addMusicFirstPlace() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		songList.add(0, new Song(title, singer));
		System.out.println("추가 성공");
		
	}
	
	// 3. 전체 곡 목록 출력
	public void showMusicList() {
		for(int i = 0; i < songList.size(); i++) {
			System.out.println(songList.get(i));
		}
	}
	
	// 4. 특정 곡 검색
	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색한 곡 명 : ");
		String searchTitle = sc.nextLine();
		
		for(int i = 0; i < songList.size(); i++) {
			if(songList.get(i).getTitle().contains(searchTitle)) {
				System.out.println(songList.get(i) + "을(를) 검색 했습니다.");
			} else if(i == songList.size() -1) {
				System.out.println("발견된 곡이 없습니다.");
			}
		}
	}
	
	// 5. 특정 곡 삭제
	public void deleteMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("검색한 곡 명 : ");
		String searchTitle = sc.nextLine();
		
		for(int i = 0; i < songList.size(); i++) {
			if(songList.get(i).getTitle().equals(searchTitle)) {
				System.out.println(songList.get(i) + "을(를) 삭제 했습니다.");
				songList.remove(i);
			} else if(i == songList.size() -1) {
				System.out.println("삭제할 곡이 없습니다.");
			}
		}
	}
	
	// 6. 특정 곡 수정
	public void updateMusic() {
		System.out.println("****** 특정 곡 수정 ******");
		System.out.print("검색한 곡 명 : ");
		String searchTitle = sc.nextLine();
		
		for(int i = 0; i < songList.size(); i++) {
			if(songList.get(i).getTitle().equals(searchTitle)) {
				System.out.print("수정할 곡 명 : ");
				String changeTitle = sc.nextLine();
				System.out.print("수정할 가수 명 : ");
				String changeSinger = sc.nextLine();
				
				System.out.println(songList.get(i) + "의 값이 변경 되었습니다.");
				
				songList.get(i).setSinger(changeSinger);
				songList.get(i).setTitle(changeTitle);
			} else if(i == songList.size() -1) {
				System.out.println("수정할 곡이 없습니다.");
			}
		}
	}
	
	// 7. 곡 명 오름차순 정렬
	public void ascendSortByTitle() {
		Collections.sort(songList);
		for(int i = 0; i < songList.size(); i++) {
			System.out.println(songList.get(i).getSinger() + " - " + songList.get(i).getTitle());
		}
	}
	
	// 8. 가수 명 내림차순 정렬
//	public void descendSortBySinger() {
//		Collections.reverse(songList);
//		for(int i = 0; i < songList.size(); i++) {
//			System.out.println(songList.get(i).getSinger() + " - " + songList.get(i).getTitle());
//		}
//	}
	
	public void descendSortBySinger() {
		Collections.sort(songList);
		for(int i = songList.size() - 1; i >= 0; i--) {
			System.out.println(songList.get(i).getSinger() + " - " + songList.get(i).getTitle());
		}
	}

}
