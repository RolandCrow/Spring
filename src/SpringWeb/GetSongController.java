package SpringWeb;


import Music.MusicService;
import Music.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;


@Controller
public class GetSongController {
    @Autowired
    MusicService service;


    @GetMapping("/artists/{artist}/songs/{name}")
    @ResponseBody
    public ResponseEntity<Song> getSong(
            @PathVariable("artist") final String artist,
            @PathVariable("name") final String name
    ) {
        String artistDecoded = URLDecoder.decode(artist, StandardCharsets.UTF_8);
        String nameDecoded = URLDecoder.decode(name, StandardCharsets.UTF_8);

        Song song = service.getSong(artistDecoded, nameDecoded);

        return new ResponseEntity<>(song, HttpStatus.OK);

    }



    }
