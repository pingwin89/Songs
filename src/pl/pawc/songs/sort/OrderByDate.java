package pl.pawc.songs.sort;

import java.util.Comparator;

import pl.pawc.songs.pojo.Song;

public class OrderByDate implements Comparator<Song>{

	public int compare(Song s1, Song s2){
		if(s1.getDate().getTime()>s2.getDate().getTime()) return 1;
		if(s1.getDate().getTime()>s2.getDate().getTime()) return -1;
		return 0;
	}
	
}