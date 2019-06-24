package com.pramati.assignment.playlistJDBC;

import java.util.Scanner;

public class PlayListClient {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char choice;
		do {
			System.out.println("User-1\tUser-2");
			int user = in.nextInt();
			PlayList playList = PlaylistDao.getPlayList(user);

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

				System.out.println("Do you want to do operation[y/n]:");
				option = in.next().charAt(0);

			} while (option == 'y');

			System.out.println("Do you want to continue[y/n]:");
			choice = in.next().charAt(0);

		} while (choice == 'y');

		in.close();

	}
}