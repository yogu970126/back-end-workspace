package com.kh.example1.practice2.compare;

import java.util.Comparator;

import com.kh.example1.practice2.model.Song2;

public class ArtistDescending implements Comparator<Song2> {

	@Override
	public int compare(Song2 o1, Song2 o2) {
		
		return o2.getArtist().compareTo(o1.getArtist());
	}
	
}
