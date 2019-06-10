package com.pramati.assignments;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PlayListClient {

	static List<Song> playlist = new ArrayList<>();
	static Scanner in = new Scanner(System.in);

	public void startUp() {
		PlayList obj = new PlayList();

		char option;

		do {
			System.out.println("1-Create playlist\n2-Display songs in playlist\n3-Add a song to playlist");
			int menu = in.nextInt();
			switch (menu) {
			case 1:
				char choice;

				do {

					doOperation();
					System.out.println("Continue to add to playlist ?[y/n]:");
					choice = in.next().charAt(0);
				} while (choice == 'y');

				break;
			case 2:
				obj.display(playlist);
				break;

			case 3:
				obj.add();
				break;

			default:
				System.out.println("No option found...");
			}

			System.out.println("Do you want to continue[y/n]:");
			option = in.next().charAt(0);

		} while (option == 'y');

	}

	public static void doOperation() {

		Album album = new Album();

		int pos, x;

		System.out.println("Enter the album ");
		System.out.println("Album-1\tAlbum-2");
		x = in.nextInt();
		Map<Integer, List<Song>> map = album.getMap();
		List<Song> temp = map.get(x);
		int i = 1;
		for (Song songs : temp) {
			System.out.println(i + " " + songs.getTitle());
			i++;
		}
		System.out.println("Enter the song to add:");
		pos = in.nextInt() - 1;
		Song song = temp.get(pos);
		if (!playlist.contains(song)) {
			playlist.add(song);
			System.out.println(song.getTitle() + " added to playlist");
		} else
			System.out.println("Song already added");

	}

	public static void main(String[] args) {
PlayListClient playListClient = new PlayListClient();
playListClient.startUp();
	}
}