package pl.pawc.songs.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Iterator;

import pl.pawc.songs.pojo.Song;

public class Parse {

	public static Song getSongFrom(String line){
		
		String[] record = line.split(";");
		
		String author = record[0];
		String tittle = record[1];
		
		long dateLong;
		try{
			dateLong = Long.parseLong(record[2]);
		}
		catch(NumberFormatException e){
			dateLong = 0;
		}
		
		Date date = new Date(dateLong);
		
		int likes;
		try{
			likes = Integer.parseInt(record[3]);
		}
		catch(NumberFormatException e){
			likes = 0;
		}
		
		return new Song(author, tittle, date, likes);
				
	}

	public static String getStringFrom(Song song){
		String author = song.getAuthor();
		String tittle = song.getTittle();
		String date = String.valueOf(song.getDate().getTime());
		String likes = String.valueOf(song.getLikes());
		
		String result = author+";"+tittle+";"+date+";"+likes;
		
		return result;
	}
	
	public static String getStringFrom(HashMap<Integer, Song> map){
		String result = "";
		for(int key : map.keySet()){
			result += getStringFrom(map.get(key));
			result += "\n";
		}
	
		return result;	
	}

	public static int getAnotherKey(HashMap<Integer, Song> map){
		Iterator iterator = map.keySet().iterator();
		int max = 0;
		while(iterator.hasNext()){
			int next = (Integer) iterator.next();
			if(next>=max) max = next;
		}
		return max+1;
	}
	
}