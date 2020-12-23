package Music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

public class TestMusicService5 extends AbstractTestNGSpringContextTests {


    @Autowired
    MusicService service;

    @Autowired
    MusicServiceTest tests;

    @Test
    public void testSongVoting() {
        tests.testSongVoting(service);
    }

    @Test
    public void testGetMatchingArtistNames() {
        tests.testSongsForArtistNames(service);
    }

    @Test
    public void testGetSongsForArtist() {
        tests.testSongForArtist(service);
    }

    @Test
    public void testMatchingSongNamesForArtist() {
        tests.testMatchingSongNamesForArtist(service);
    }




}
