package com.pramati.assignment.playlist;

import java.util.HashSet;
import java.util.Set;

public class Album {
	Set<Song> songs = new HashSet<>();

	public Set<Song> getSongs() {
		return songs;
	}

	public void add(Song song) {
		songs.add(song);
	}

	public void remove(Song song) {
		songs.remove(song);
	}
}
