package com.bej.tracks.controller;

import com.bej.tracks.model.Track;
import com.bej.tracks.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Track entities.
 */
@RestController
@RequestMapping("/api/v1")
public class TrackController {
	// create an instance of the ITrackService interface for business logic
	private ITrackService trackService;
	/**
	 * Constructor for the TrackController class.
	 */
	@Autowired
	public TrackController(ITrackService trackService) {
		this.trackService = trackService;
	}

	/**
	 * Endpoint to add a new track.
	 */
	@PostMapping ("/create")
	public ResponseEntity<?> addTrack(@RequestBody Track track) {
		// Add the logic to add a new track
		return new ResponseEntity<>(trackService.addTrack(track),HttpStatus.CREATED);
	}

	/**
	 * Endpoint to retrieve all tracks.
	 */
	@GetMapping("/read")
	public ResponseEntity<?> findAllTracks() {
		// Add the logic to retrieve all tracks
		return new ResponseEntity<>(trackService.findAllTracks(),HttpStatus.OK);
	}

	/**
	 * Endpoint to delete a track by its ID.
	 */
	@DeleteMapping("/delete/{trackId}")
	public ResponseEntity<?> deleteTrack(@PathVariable int trackId) {
		// Add the logic to delete a track by its ID
		trackService.deleteTrack(trackId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Endpoint to find tracks by the given artist.
	 */
	@GetMapping("/trackArtist/{artist}")
	public ResponseEntity<?> findTrackByArtist(@PathVariable String artist) {
		// Add the logic to find tracks by artist
		return new ResponseEntity<>(trackService.findTrackByArtist(artist),HttpStatus.OK);
	}

	/**
	 * Endpoint to find tracks with the given rating.
	 */
	@GetMapping("/trackRating/{rating}")
	public ResponseEntity<?> findTrackByRating(@PathVariable int rating) {
		// Add the logic to find tracks by rating
		return new ResponseEntity<>(trackService.findTrackByRating(rating),HttpStatus.OK);
	}

	/**
	 * Endpoint to find tracks with duration less than or equal to the given duration.
	 */
	@GetMapping("/trackDuration/{duration}")
	public ResponseEntity<?> findTracksByDurationLessThanOrEqual(@PathVariable double duration) {
		// Add the logic to find tracks by duration
		return new ResponseEntity<>(trackService.findTracksByDurationLessThan(duration),HttpStatus.OK);
	}

	/**
	 * Endpoint to find tracks with rating greater than the given rating.
	 */
	@GetMapping("/greaterRating/{rating}")
	public ResponseEntity<?> findTrackByRatingGreaterThan(@PathVariable int rating) {
		// Add the logic to find tracks by rating greater than
		return new ResponseEntity<>(trackService.findTrackByRatingGreaterThan(rating),HttpStatus.OK);
	}

	/**
	 * Endpoint to find tracks with rating between the given minimum and maximum ratings.
	 */
	@GetMapping("/findTrackByRatingBetween/{minRating}/{maxRating}")
	public ResponseEntity<?> findTrackByRatingBetween(@PathVariable int minRating, @PathVariable int maxRating) {
		// Add the logic to find tracks by rating between min and max
		return new ResponseEntity<>(trackService.findTrackByRatingBetween(minRating,maxRating),HttpStatus.OK);
	}

	/**
	 * Endpoint to find tracks whose track name starts with the given prefix.
	 */
	@GetMapping("/findTrackByTrackNameStartingWith/{trackName}")
	public ResponseEntity<?> findTrackByTrackNameStartingWith(@PathVariable String trackName) {
		// Add the logic to find tracks by track name prefix
		return new ResponseEntity<>(trackService.findTrackByTrackNameStartingWith(trackName),HttpStatus.OK);
	}

	/**
	 * Endpoint to find tracks ordered by rating in descending order.
	 */
	@GetMapping("/findTracksByOrderByRatingDesc/desc")
	public ResponseEntity<?> findTrackByOrderByRatingDesc() {
		// Add the logic to find tracks ordered by rating in descending order
		return new ResponseEntity<>(trackService.findTrackByOrderByRatingDesc(),HttpStatus.OK);
	}

	/**
	 * Endpoint to find tracks whose genre is in the given list of genres.
	 */
	@GetMapping("/findTrackByGenresIn/{genre}")
	public ResponseEntity<?> findTrackByGenreIn(@PathVariable List<String> genre) {
		// Add the logic to find tracks by genres
		return new ResponseEntity<>(trackService.findTrackByGenreIn(genre),HttpStatus.FOUND);
	}

	/**
	 * Endpoint to find tracks for the given album and artist, ordered by track name in ascending order.
	 */
	@GetMapping("/findTrackByAlbumAndArtistOrderByTrackNameAsc/{album}/{artist}")
	public ResponseEntity<?> findTrackByAlbumAndArtistOrderByTrackNameAsc(@PathVariable String album, @PathVariable String artist) {
		// Add the logic to find tracks by album and artist, ordered by track name in ascending order
		return new ResponseEntity<>(trackService.findTrackByAlbumAndArtistOrderByTrackNameAsc(album,artist),HttpStatus.FOUND);
	}
}