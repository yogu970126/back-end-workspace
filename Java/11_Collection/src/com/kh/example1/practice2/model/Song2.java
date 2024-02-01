package com.kh.example1.practice2.model;

public class Song2 {
	
	private String title;
	private String artist;
	
	public Song2() {}

	public Song2(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return artist + " - " + title ;
	}

	
	
	
	

}
