package com.bej.tracks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a music track entity.
 */
@Entity
public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trackId;
	private String trackName;
	private String artist;
	private double duration;
	private int rating;
	private String genre;
	private int releaseYear;
	private String album;
	private String composer;
	/**
	 * The name of the track.
	 * The artist of the track.
	 * The duration of the track.
	 * The rating of the track.
	 * The genre of the track.
	 * The release year of the track.
	 * The album of the track.
	 * The composer of the track.
	 */

	/**
	 * Parameterized constructor.
	 *
	 * @param trackId     The unique identifier of the track.
	 * @param trackName   The name of the track.
	 * @param artist      The artist of the track.
	 * @param duration    The duration of the track.
	 * @param rating      The rating of the track.
	 * @param genre       The genre of the track.
	 * @param releaseYear The release year of the track.
	 * @param album       The album of the track.
	 * @param composer    The composer of the track.
	 */
	public Track(int trackId, String trackName, String artist, double duration, int rating, String genre, int releaseYear, String album, String composer) {
		this.trackId = trackId;
		this.trackName = trackName;
		this.artist = artist;
		this.duration = duration;
		this.rating = rating;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.album = album;
		this.composer = composer;
	}

	public Track() {
	}

	public int getTrackId() {
		return trackId;
	}

	// Getters and setters for all fields

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}


	// toString() method


	@Override
	public String toString() {
		return "Track{" +
				"trackId=" + trackId +
				", trackName='" + trackName + '\'' +
				", artist='" + artist + '\'' +
				", duration=" + duration +
				", rating=" + rating +
				", genre='" + genre + '\'' +
				", releaseYear=" + releaseYear +
				", album='" + album + '\'' +
				", composer='" + composer + '\'' +
				'}';
	}
}