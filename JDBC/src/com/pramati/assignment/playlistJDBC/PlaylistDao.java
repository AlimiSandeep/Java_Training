package com.pramati.assignment.playlistJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaylistDao {

	static Connection conn = null;

	public static PlayList getPlayList(int user) {
		Album album1 = new Album();

		try {

			conn = DBConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					"select song_name,song_duration,singer from songs s INNER JOIN playlist p on s.song_id=p.song_id INNER JOIN playlistinfo pf on p.playlist_id=pf.playlist_id where pf.user=?;");
			ps.setInt(1, user);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				album1.add(new Song(rs.getString("song_name"), rs.getString("song_duration"), rs.getString("singer")));
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		PlayList playList = new PlayList();
		playList.add(album1.getSongs());

		return playList;
	}

}
