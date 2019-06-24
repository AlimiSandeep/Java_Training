package com.pramati.assignment.playlist;

import java.util.Scanner;

public class PlayListClient {

	static Scanner in = new Scanner(System.in);

	public void startUp() {
		Album album1 = new Album();
		Album album2 = new Album();

		album1.add(new Song("All we Know", 150));
		album1.add(new Song("Closer", 180));
		album1.add(new Song("Blank space", 300));

		album2.add(new Song("Shape of u", 240));
		album2.add(new Song("Beautiful", 180));
		album2.add(new Song("Faded", 270));

		PlayList playList = new PlayList();
		playList.add(album1.getSongs());

		char option;

		do {
			System.out.println(
					"1-Display songs in playlist\n2-Forward\n3-Backward\n4-Current song\n5-Remove current song");
			int menu = in.nextInt();
			switch (menu) {
			case 1:
				playList.display();
				break;
			case 2:
				System.out.println(playList.nextSong());
				break;
			case 3:
				Song previousSong = playList.previousSong();
				if (previousSong == null)
					System.out.println("No songs backward.");
				else
					System.out.println(previousSong);
				break;
			case 4:
				System.out.println(playList.currentSong());
				break;
			case 5:
				if (playList.remove())
					System.out.println("Successfully removed");
				break;

			default:
				System.out.println("No option found...");
			}

			System.out.println("Do you want to continue[y/n]:");
			option = in.next().charAt(0);

		} while (option == 'y');

	}

	public static void main(String[] args) {
		PlayListClient playListClient = new PlayListClient();
		playListClient.startUp();
	}
}