package Music;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractMusicService {
    private Map<String, Artist> band = new HashMap<>();

    protected String transformArtist(String input) {
        return input;
    }

    protected String transformSong(String input) {
        return input;
    }

    public void reset() {
        band.clear();
    }

    private Artist getArtist(String name) {
        String normalizedName  = transformArtist(name);
        return band.computeIfAbsent(normalizedName,
                s-> new Artist(normalizedName));
    }


    public Song getSong(String artistName, String name) {
        Artist artist = getArtist(artistName);
        String normalizedTitle = transformSong(name);
        return artist.getSongs().computeIfAbsent(normalizedTitle, Song::new);
    }

    public List<Song> getSongForArtists(String artist) {
        List<Song> songs = new ArrayList<>(
                getArtist(artist).getSongs().values()
        );
        songs.sort(Song::compareTo);
        return songs;
    }


    public List<String> getMatchingSongNamesForArtist(String artist, String prefix) {
        String normalizedPrefix = transformSong(prefix).toLowerCase();
        return getArtist(artist).getSongs().keySet().stream().map(this:: transformSong)
                .filter(name -> name.toLowerCase().startsWith(normalizedPrefix))
                        .sorted(Comparator.comparing(Function.identity()))
                        .collect(Collectors.toList());
    }


    public List<String> getMatchingArtistName(String prefix) {
        String normalizedPrefix = transformArtist(prefix).toLowerCase();
        return band.keySet().stream().filter(name -> name.toLowerCase().startsWith(normalizedPrefix))
                .sorted(Comparator.comparing(Function.identity()))
                .collect(Collectors.toList());
    }


    public Song voteForSong(String artistName, String name) {
        Song song = getSong(artistName, name);
        song.setVotes(song.getVotes() + 1);
        return  song;
    }


}
