package com.pramati.assignment.playlistJDBC;

public class Song {

	private String title;
	private String duration;
	private String singer;

	public Song(String title, String duration, String singer) {
		super();
		this.title = title;
		this.duration = duration;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Title=" + title + " ,Duration=" + duration + " Singer=" + singer;
	}

}
