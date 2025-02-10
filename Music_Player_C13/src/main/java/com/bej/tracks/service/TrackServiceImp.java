package com.bej.tracks.service;

import com.bej.tracks.model.Track;
import com.bej.tracks.repository.ITrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the ITrackService interface.
 */
@Service
public class TrackServiceImp implements ITrackService {

	// create an instance of Repository for accessing Track data
	private ITrackRepository trackRepository;

	/**
	 * Constructor for the TrackServiceImpl class.
	 */
	@Autowired
	public TrackServiceImp(ITrackRepository trackRepository) {
		this.trackRepository = trackRepository;
	}

	/**
	 * Adds a new track.
	 */
	@Override
	public Track addTrack(Track track) {
		// Write the logic to add the track
		return trackRepository.save(track);
	}

	/**
	 * Deletes a track by its ID.
	 */
	@Override
	public void deleteTrack(int trackId) {
		// Write the logic to delete the track
		System.out.println("Deleleting track with Id"+trackId);
		trackRepository.deleteById(trackId);
		System.out.println("Track after deletion"+trackRepository.findAll().size());
	}

	/**
	 * Finds all tracks.
	 */
	@Override
	public List<Track> findAllTracks() {
		// Write the logic to find all tracks
		return trackRepository.findAll();
	}

	/**
	 * Finds a list of tracks by the given artist.
	 */
	@Override
	public List<Track> findTrackByArtist(String artist) {
		// Write the logic to find tracks by artist
		return trackRepository.findByArtist(artist);
	}

	/**
	 * Finds a list of tracks with the given rating.
	 */
	@Override
	public List<Track> findTrackByRating(int rating) {
		// Write the logic to find tracks by rating
		return trackRepository.findByRating(rating);
	}

	/**
	 * Finds a list of tracks with duration less than the given duration.
	 */
	@Override
	public List<Track> findTracksByDurationLessThan(double duration) {
		// Write the logic to find tracks by duration
		return trackRepository.findByDurationLessThan(duration);
	}

	/**
	 * Finds a list of tracks with rating greater than the given rating.
	 */
	@Override
	public List<Track> findTrackByRatingGreaterThan(int rating) {
		// Write the logic to find tracks by rating greater than
		return trackRepository.findByRatingGreaterThan(rating);
	}

	/**
	 * Finds a list of tracks with rating between the given minimum and maximum ratings.
	 */
	@Override
	public List<Track> findTrackByRatingBetween(int minRating, int maxRating) {
		// Write the logic to find tracks by rating between min and max
		return trackRepository.findByRatingBetween(minRating,maxRating);
	}

	/**
	 * Finds a list of tracks whose track name starts with the given prefix.
	 */
	@Override
	public List<Track> findTrackByTrackNameStartingWith(String trackName) {
		// Write the logic to find tracks by track name prefix
		return trackRepository.findByTrackNameStartingWith(trackName);
	}

	/**
	 * Finds a list of tracks ordered by rating in descending order.
	 */
	@Override
	public List<Track> findTrackByOrderByRatingDesc() {
		// Write the logic to find tracks ordered by rating in descending order
		return trackRepository.findByOrderByRatingDesc();
	}

	/**
	 * Finds a list of tracks whose genre is in the given list of genres.
	 */
	@Override
	public List<Track> findTrackByGenreIn(List<String> genre) {
		// Write the logic to find tracks by genres
		return trackRepository.findByGenreIn(genre);
	}

	/**
	 * Finds a list of tracks for the given album and artist, ordered by track name in ascending order.
	 */
	@Override
	public List<Track> findTrackByAlbumAndArtistOrderByTrackNameAsc(String album, String artist) {
		// Write the logic to find tracks by album and artist, ordered by track name in ascending order
		return trackRepository.findByAlbumAndArtistOrderByTrackNameAsc(album,artist);
	}
}