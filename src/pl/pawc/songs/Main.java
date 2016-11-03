package pl.pawc.songs;

import java.util.Scanner;
import java.util.HashMap;

import pl.pawc.songs.pojo.Song;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static HashMap<Integer, Song> map = new HashMap<Integer, Song>();
	
	public static void main(String args[]){
		
		String input = "";
		
		while(!"exit".equals(input)){
			input = sc.nextLine();
			CommandHandler.handle(input);
		}
		
	}
	
}