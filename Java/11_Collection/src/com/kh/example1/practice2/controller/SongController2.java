package com.kh.example1.practice2.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example1.practice2.compare.ArtistDescending;
import com.kh.example1.practice2.compare.TitleAscending;
import com.kh.example1.practice2.model.Song2;

public class SongController2 {
	
	private ArrayList<Song2> list = new ArrayList<>();
	
	// 싱글톤 패턴(Singleton Pattern)
	// - 디자인 패턴 중 하나로 클래스가 최대 한 번만 객체 생성되도록 하는 패턴
	
	// 1. 생성자는 private
	private SongController2() {}
	
	// 2. 유일한 객체를 담을 static 변수
	private static SongController2 instance;
	
	// 3. 객체를 반환하는 정적 메서드
	public static SongController2 getInstance() {
		if(instance == null) instance = new SongController2();
		return instance;
	}
 	
	public boolean addLastList(Song2 song) {
		if(!song.getTitle().equals("") && !song.getArtist().equals("")) {
			return list.add(song);
		} 
		return false;
	}

	public boolean addFirstList(Song2 song) {
		if(!song.getTitle().equals("") && !song.getArtist().equals("")) {
			list.add(0, song);
			return true;
		}
		return false;
	}
	
	public ArrayList<Song2> printAll() {
		return list;
	}
	
	public Song2 searchSong(String title) {
		for(Song2 song : list) {
			if(song.getTitle().contains(title)) {
				return song;
			}
		}
		return null;
	}
	
	public Song2 removeSong(String title) {
		for(Song2 song : list) {
			if(song.getTitle().equals(title)) {	
				return list.remove(list.indexOf(song));
			}
		}
		return null;
	}
	
	public Song2 updateSong(String search, Song2 update) {
		for(Song2 song : list) {
			if(song.getTitle().equals(search)) {
				return list.set(list.indexOf(song), update);
			}
		}
		return null;
	}
	
	public ArrayList<Song2> ascTitle() {
		ArrayList<Song2> cloneList = (ArrayList<Song2>)list.clone(); // 리스트 깊은 복사해서 새로운 리스트에 넣기
		Collections.sort(cloneList, new TitleAscending());
		return cloneList;
	}
	
	public ArrayList<Song2> descArtist() {
		ArrayList<Song2> cloneList = (ArrayList<Song2>) list.clone();
		Collections.sort(cloneList, new ArtistDescending());
		return cloneList;
	}
	
	
	
	
}




















