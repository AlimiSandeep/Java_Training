package com.pramati.assignments;

import java.util.List;

public class PlayList {

	

	public void add() {
		PlayListClient.doOperation();
	}

	public void remove() {
		
	}

	public void forward() {

	}

	public void backward() {

	}

	public void display(List<Song> playlist) {
		playlist.stream().forEach(System.out::println);
	}

}
