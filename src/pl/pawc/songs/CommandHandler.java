package pl.pawc.songs;

import java.util.Iterator;

import pl.pawc.songs.pojo.Song;
import pl.pawc.songs.util.Parse;

public class CommandHandler {

	public static void handle(String input){
		
		switch(input){
		
		case "exit" : log("Good bye"); break;
		case "load" : Main.map = Database.load(); break;
		case "save" : Database.save(Main.map); break;
		case "add" :  add(); break;
		case "list" : list(); break;
			
		}
	}
	
	private static void list(){
		for(int key : Main.map.keySet()){
			log(key+": "+Main.map.get(key).toString());
		}
	}	

	private static void add() {
		String author = Main.sc.nextLine();
		String tittle = Main.sc.nextLine();
		int nextKey = Parse.getAnotherKey(Main.map);
		Song song = new Song(author, tittle);
		Main.map.put(nextKey, song);
	}
	
	public static void log(String text){
		System.out.println(text);
	}
	
}
