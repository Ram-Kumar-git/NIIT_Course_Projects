package com.bej.tracks.controller;

import com.bej.tracks.model.Track;
import com.bej.tracks.service.ITrackService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrackControllerTest {

	@Autowired
	private TrackController trackController;

	@Autowired
	private ITrackService trackService;

	private Track track1;
	private Track track2;
	private Track track3;

	@BeforeEach
	public void setUp() {
		track1 = new Track(1, "Bohemian Rhapsody", "Queen", 5.55, 5, "Rock", 1975, "A Night at the Opera", "Freddie Mercury");
		track2 = new Track(2, "Shape of You", "Ed Sheeran", 3.53, 4, "Pop", 2017, "÷", "Ed Sheeran");
		track3 = new Track(3, "Stairway to Heaven", "Led Zeppelin", 7.55, 5, "Rock", 1971, "Led Zeppelin IV", "Jimmy Page/Robert Plant");

		trackService.addTrack(track1);
		trackService.addTrack(track2);
		trackService.addTrack(track3);
	}

	@AfterEach
	public void tearDown() {
		trackService.deleteTrack(track1.getTrackId());
		trackService.deleteTrack(track2.getTrackId());
		trackService.deleteTrack(track3.getTrackId());
	}

	@Test
	public void testAddTrack() {
		Track newTrack = new Track(4, "Imagine", "John Lennon", 3.03, 5, "Rock", 1971, "Imagine", "John Lennon");
		ResponseEntity<?> response = trackController.addTrack(newTrack);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertTrue(response.getBody() instanceof Track);
		Track addedTrack = (Track) response.getBody();
		trackService.deleteTrack(addedTrack.getTrackId());
	}

	@Test
	public void testGetAllTracks() {
		ResponseEntity<?> response = trackController.findAllTracks();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		List<Track> tracks = (List<Track>) response.getBody();
		assertEquals(3, tracks.size());
	}

	@Test
	public void findTracksByDurationLessThanOrEqual() {
		ResponseEntity<?> response = trackController.findTracksByDurationLessThanOrEqual(4.0);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		List<Track> tracks = (List<Track>) response.getBody();
		assertEquals(1, tracks.size());
	}

	@Test
	public void testGetTracksByArtist() {
		ResponseEntity<?> response = trackController.findTrackByArtist("Queen");
		assertEquals(HttpStatus.OK, response.getStatusCode());
		List<Track> tracks = (List<Track>) response.getBody();
		assertEquals(1, tracks.size());
	}

	@Test
	public void testGetTracksByRating() {
		ResponseEntity<?> response = trackController.findTrackByRating(5);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		List<Track> tracks = (List<Track>) response.getBody();
		assertEquals(2, tracks.size());
	}

	@Test
	public void testGetTracksByRatingGreaterThan() {
		ResponseEntity<?> response = trackController.findTrackByRatingGreaterThan(4);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		List<Track> tracks = (List<Track>) response.getBody();
		assertEquals(2, tracks.size());
	}

	@Test
	public void testGetTracksByRatingBetween() {
		ResponseEntity<?> response = trackController.findTrackByRatingBetween(4, 5);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		List<Track> tracks = (List<Track>) response.getBody();
		assertEquals(3, tracks.size());
	}

	@Test
	public void testGetTracksByTrackNameStartingWith() {
		ResponseEntity<?> response = trackController.findTrackByTrackNameStartingWith("S");
		assertEquals(HttpStatus.OK, response.getStatusCode());
		List<Track> tracks = (List<Track>) response.getBody();
		assertEquals(2, tracks.size());
	}

	@Test
	public void testGetTracksByOrderByRatingDesc() {
		ResponseEntity<?> response = trackController.findTrackByOrderByRatingDesc();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		List<Track> tracks = (List<Track>) response.getBody();
		assertEquals(3, tracks.size());
	}

	@Test
	public void testDeleteTrack() {
		ResponseEntity<?> response = trackController.deleteTrack(track1.getTrackId());
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		List<Track> tracks = trackService.findAllTracks();
		assertEquals(2, tracks.size());
	}
}