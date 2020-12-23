package Music;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

public class TestMusicService2 extends AbstractTestNGSpringContextTests {
    @Autowired
    MusicService service;
    MusicServiceTest tests = new MusicServiceTest();

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
