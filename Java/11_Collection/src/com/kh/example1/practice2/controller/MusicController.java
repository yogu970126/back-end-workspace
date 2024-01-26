package com.kh.example1.practice2.controller;

public class MusicController {
	
	public showMusicList() {
		for(int i = 0; i < songList.size(); i++) {
			System.out.println(songList.get(i).getSinger() + " - " + songList.get(i).getTitle());
		}
	}

}
