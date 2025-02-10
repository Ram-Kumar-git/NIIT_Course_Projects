package com.bej.tracks.service;

import com.bej.tracks.model.Track;
import com.bej.tracks.repository.ITrackRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrackServiceImpTest {

	@Autowired
	private ITrackRepository trackRepository;

	@Autowired
	private TrackServiceImp trackServiceImp;

	private Track track1;
	private Track track2;
	private Track track3;

	@BeforeEach
	public void setUp() {
		track1 = new Track(1, "Bohemian Rhapsody", "Queen", 5.55, 5, "Rock", 1975, "A Night at the Opera", "Freddie Mercury");
		track2 = new Track(2, "Shape of You", "Ed Sheeran", 3.53, 4, "Pop", 2017, "÷", "Ed Sheeran");
		track3 = new Track(3, "Stairway to Heaven", "Led Zeppelin", 7.55, 5, "Rock", 1971, "Led Zeppelin IV", "Jimmy Page/Robert Plant");

		trackServiceImp.addTrack(track1);
		trackServiceImp.addTrack(track2);
		trackServiceImp.addTrack(track3);
	}

	@AfterEach
	public void tearDown() {
		trackRepository.deleteAll();
	}

	@Test
	public void testAddTrack() {
		Track newTrack = new Track(4, "Imagine", "John Lennon", 3.03, 5, "Rock", 1971, "Imagine", "John Lennon");
		Track savedTrack = trackServiceImp.addTrack(newTrack);
		assertNotNull(savedTrack);
	}

	@Test
	public void testGetTrackByDurationLessThan() {
		List<Track> tracks = trackServiceImp.findTracksByDurationLessThan(4.0);
		assertEquals(1, tracks.size());
	}

	@Test
	public void testGetTrackByRatingGreaterThan() {
		List<Track> tracks = trackServiceImp.findTrackByRatingGreaterThan(4);
		assertEquals(2, tracks.size());
	}

	@Test
	public void testGetTrackByArtist() {
		List<Track> tracks = trackServiceImp.findTrackByArtist("Queen");
		assertEquals(1, tracks.size());
	}

	@Test
	public void testGetTrackByRating() {
		List<Track> tracks = trackServiceImp.findTrackByRating(5);
		assertEquals(2, tracks.size());
	}

	@Test
	public void testGetTrackByRatingBetween() {
		List<Track> tracks = trackServiceImp.findTrackByRatingBetween(4, 5);
		assertEquals(3, tracks.size());
	}

	@Test
	public void testGetTrackByTrackNameStartingWith() {
		List<Track> tracks = trackServiceImp.findTrackByTrackNameStartingWith("S");
		assertEquals(2, tracks.size());
	}

	@Test
	public void testGetTrackByOrderByRatingDesc() {
		List<Track> tracks = trackServiceImp.findTrackByOrderByRatingDesc();
		assertEquals(3, tracks.size());
	}

	@Test
	public void testGetTrackByGenreIn() {
		List<String> genres = Arrays.asList("Rock", "Pop");
		List<Track> tracks = trackServiceImp.findTrackByGenreIn(genres);
		assertEquals(3, tracks.size());
	}

	@Test
	public void testGetTrackByAlbumAndArtistOrderByTrackNameAsc() {
		List<Track> tracks = trackServiceImp.findTrackByAlbumAndArtistOrderByTrackNameAsc("A Night at the Opera", "Queen");
		assertEquals(1, tracks.size());
	}

	@Test
	public void testDeleteTrack() {
		trackServiceImp.deleteTrack(track1.getTrackId());
		List<Track> tracks = trackServiceImp.findAllTracks();
		assertEquals(2, tracks.size());
	}
}