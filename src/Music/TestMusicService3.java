package Music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

public class TestMusicService3 extends AbstractTestNGSpringContextTests {
    @Autowired
    MusicService service;

   MusicServiceTest  tests = new MusicServiceTest();

   @Test
   public void testSongVoting() {
       tests.testSongVoting(service);
   }

   @Test
    public void testMatchingSongNamesForArtist() {
       tests.testMatchingSongNamesForArtist(service);
   }






}
