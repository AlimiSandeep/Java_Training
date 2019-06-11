package com.pramati.assignment.playlist;

public class Song {

	private String title;
	private int duration;

	public Song(String title, int duration) {
		super();
		this.title = title;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Title=" + title + " ,Duration=" + duration;
	}

}
