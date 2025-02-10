package com.bej.tracks.service;

import com.bej.tracks.model.Track;

import java.util.List;
import java.util.Map;

public interface ITrackService {

	// Method for adding a track
	Track addTrack(Track track);

	// Method for deleting a track
	void deleteTrack(int trackId);

	List<Track> findAllTracks();
	// Methods from the ITrackRepository
	List<Track> findTrackByArtist(String artist);
	List<Track> findTrackByRating(int rating);
	List<Track> findTracksByDurationLessThan(double duration);
	List<Track> findTrackByRatingGreaterThan(int rating);
	List<Track> findTrackByRatingBetween(int minRating, int maxRating);
	List<Track> findTrackByTrackNameStartingWith(String trackName);
	List<Track> findTrackByOrderByRatingDesc();
	List<Track> findTrackByGenreIn(List<String> genre);
	List<Track> findTrackByAlbumAndArtistOrderByTrackNameAsc(String album, String artist);



}
