package pl.pawc.songs.pojo;

import java.util.Date;

public class Song {
	
	private String author;
	private String tittle;
	private Date date;
	private int likes;

	public Song(String author, String tittle){
		this.author = author;
		this.tittle = tittle;
		date = new Date();
		likes = 0;
	}
	
	public Song(String author, String tittle, Date date, int likes){
		this.author = author;
		this.tittle = tittle;
		this.date = date;
		this.likes = likes;
	}
	
	public String toString(){
		return author+" - "+tittle+", "+date.toString()+", likes: "+likes;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getTittle(){
		return tittle;
	}
	
	public Date getDate(){
		return date;
	}
	
	public int getLikes(){
		return likes;
	}
	
	public void addLike(){
		likes++;
	}
}