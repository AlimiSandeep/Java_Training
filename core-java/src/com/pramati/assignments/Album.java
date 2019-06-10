package com.pramati.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album {
	List<Song> album1 = new ArrayList<>();
	List<Song> album2 = new ArrayList<>();
	Map<Integer, List<Song>> map = new HashMap<>();

	public Album() {

		album1.add(new Song("All we Know", 150));
		album1.add(new Song("Closer", 180));
		album1.add(new Song("Blank space", 300));

		album2.add(new Song("Shape of u", 240));
		album2.add(new Song("Beautiful", 180));
		album2.add(new Song("Faded", 270));

		map.put(1, album1);
		map.put(2, album2);

	}

	public List<Song> getAlbum1() {
		return album1;
	}

	public List<Song> getAlbum2() {
		return album2;
	}

	public Map<Integer, List<Song>> getMap() {
		return map;
	}

}
