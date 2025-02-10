package com.bej.tracks.repository;

import com.bej.tracks.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Track entities.
 */
@Repository
public interface ITrackRepository extends JpaRepository<Track, Integer> {

	/**
	 * Finds a list of tracks by the given artist.
	 */
	public List<Track> findByArtist(String artist);

	/**
	 * Finds a list of tracks with the given rating.
	 */
	public List<Track> findByRating(int rating);
	/**
	 * Finds a list of tracks with duration less than the given duration.
	 */
	public List<Track> findByDurationLessThan(double duration);

	/**
	 * Finds a list of tracks with rating greater than the given rating.
	 */
	public List<Track> findByRatingGreaterThan(int rating);
	/**
	 * Finds a list of tracks with rating between the given minimum and maximum ratings.
	 */
	public List<Track>  findByRatingBetween(int minRating, int maxRating);
	/**
	 * Finds a list of tracks whose track name starts with the given prefix.
	 */
	public List<Track> findByTrackNameStartingWith(String trackName);

	/**
	 * Finds a list of tracks ordered by rating in descending order.
	 */
	public List<Track> findByOrderByRatingDesc();

	/**
	 * Finds a list of tracks whose genre is in the given list of genres.
	 */
	public List<Track> findByGenreIn(List<String> genre);

	/**
	 * Finds a list of tracks for the given album and artist, ordered by track name in ascending order.
	 */
	public List<Track> findByAlbumAndArtistOrderByTrackNameAsc(String album, String artist);

}