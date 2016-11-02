package pl.pawc.songs;

import pl.pawc.songs.pojo.Song;
import pl.pawc.songs.util.Parse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Database {

	public static void save(HashMap<Integer, Song> map){
		FileWriter fw = null;
		try {
			fw = new FileWriter("database");
			String records = Parse.getStringFrom(map);
			fw.write(records);
			fw.flush();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			close(fw);
		}				
	}
	
	public static HashMap<Integer, Song> load(){
		FileReader fr = null;
		HashMap<Integer, Song> map = new HashMap<Integer, Song>();
		int key = 1;
		try{
			fr = new FileReader("database");
			BufferedReader bfr = new BufferedReader(fr);
			String line = null;
			while((line = bfr.readLine())!= null){
				map.put(key, Parse.getSongFrom(line));
				key++;
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			map = new HashMap<Integer, Song>();
		}
		catch(IOException e){
			e.printStackTrace();
			map = new HashMap<Integer, Song>();
		}
		finally{
			close(fr);
			return map;
		}
		
	}
	
	private static void close(FileWriter fw){
		try{
			fw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private static void close(FileReader fr){
		try{
			fr.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}