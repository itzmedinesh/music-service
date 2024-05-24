package com.diligent.music.album;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AlbumResource {

    private final List<Album> albums = new ArrayList<>();

    public AlbumResource() {
        albums.add(new Album(1, "album1", "Album One", "Artist 1"));
        albums.add(new Album(2, "album2", "Album Two", "Artist 2"));
        albums.add(new Album(3, "album3", "Album Three", "Artist 3"));
    }

    @GetMapping("/albums")
    public List<Album> getAlbums() {
        return albums;
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<?> getAlbum(@PathVariable("id") Integer id) {
        Optional<Album> optalbum = albums.stream().filter(album -> album.id() == id).findFirst();

        if (optalbum.isEmpty())
            return new ResponseEntity<>("""
                    {
                        "status" : "Album not found"
                    }
                    """, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(optalbum.get(), HttpStatus.OK);
    }

}
