package pl.pawc.songs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;

import pl.pawc.songs.pojo.Song;

public class CommandHandler {

	public static void handle(String input){
		
		switch(input){
		
		case "exit" : log("Good bye"); break;
		case "load" : Main.map = Database.load(); break;
		case "save" : Database.save(Main.map); break;
		case "add" :  add(); break;
		case "list" : list(Main.map); break;
		case "like" : like(); break;
		case "top" : top(); break;
			
		}
	}
	
	private static void top(){
		ArrayList<Song> list = Util.getArrayListFrom(Main.map);
		Collections.sort(list);
		list(list);
	}
	
	private static void like(){
		int number = 0;
		try{
			number = Main.sc.nextInt();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(number != 0) Main.map.get(number).addLike();
	}
	
	private static void list(HashMap<Integer, Song> map){
		for(int key : map.keySet()){
			log(key+": "+ map.get(key).toString());
		}
	}	
	
	private static void list(ArrayList<Song> list){
		int i = 1;
		for(Song song : list){
			log(i+": "+ song.toString());
		}
	}

	private static void add() {
		String author = Main.sc.nextLine();
		String tittle = Main.sc.nextLine();
		int nextKey = Util.getAnotherKey(Main.map);
		Song song = new Song(author, tittle);
		Main.map.put(nextKey, song);
	}
	
	public static void log(String text){
		System.out.println(text);
	}
	
}