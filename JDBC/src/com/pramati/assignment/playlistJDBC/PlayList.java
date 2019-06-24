package com.pramati.assignment.playlistJDBC;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlayList {

	private List<Song> songs = new ArrayList<>();

	private int currentSong = 0;
	private int nextSong = 1;
	private int previousSong = -1;

	public List<Song> getSongs() {
		return songs;
	}

	public void add(Song song) {
		if (!songs.contains(song)) {
			songs.add(song);
		}
	}

	public Song currentSong() {
		if (songs.isEmpty()) {
			return null;
		}
		return songs.get(currentSong);
	}

	public Song previousSong() {
		if (currentSong == 0) {
			return null;
		}

		previousSong = currentSong - 1;
		currentSong--;
		return songs.get(previousSong);
	}

	public Song nextSong() {
		if (currentSong == (songs.size() - 1)) {
			currentSong=0;
			return songs.get(0);
			
		}

		nextSong = currentSong + 1;
		currentSong++;
		return songs.get(nextSong);
	}

	public void add(Set<Song> song) {
		songs.addAll(song);
	}

	public boolean remove() {
		if(songs.remove(currentSong) == null)
		return false;
		return true;
	}

	public void display() {
		songs.stream().forEach(e -> System.out.println(e.getTitle()));
	}

	
}
