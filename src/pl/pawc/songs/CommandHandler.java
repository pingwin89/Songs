package pl.pawc.songs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;

import pl.pawc.songs.pojo.Song;
import pl.pawc.songs.sort.OrderByDate;

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
		case "worst" : worst(); break;
		case "recent" : recent(); break;
		case "oldest" : oldest(); break;
			
		}
	}
	
	private static void recent(){
		ArrayList<Song> list = Util.getArrayListFrom(Main.map);
		Collections.sort(list, new OrderByDate());
		list(list);
	}
	
	private static void oldest(){
		ArrayList<Song> list = Util.getArrayListFrom(Main.map);
		Collections.sort(list, Collections.reverseOrder(new OrderByDate()));
		list(list);
	}
	
	private static void worst(){
		ArrayList<Song> list = Util.getArrayListFrom(Main.map);
		Collections.sort(list, Collections.reverseOrder());
		list(list);
	}	
	
	private static void top(){
		ArrayList<Song> list = Util.getArrayListFrom(Main.map);
		Collections.sort(list);
		list(list);
	}
	
	private static void like(){
		int number = 0;
		log("Enter a number");
		try{
			number = Main.sc.nextInt();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(number != 0){
			Song song = Main.map.get(number);
			if(song != null){ song.addLike(); }
			else{ log("No such element"); }
		}
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