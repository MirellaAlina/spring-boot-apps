package ar.com.ada.second.tdvr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "songs")
public class SongController {

    @GetMapping({ "/", "" })
    public ResponseEntity getSongsMethod() {
        return null;
    }

    @GetMapping({ "/{id}", "/{id}/" })
    public ResponseEntity getASongByIdMethod() {
        return null;
    }

    @PostMapping({ "/", "" })
    public ResponseEntity postSongtMethod() {
        return null;
    }

    @PutMapping({ "/{id}", "/{id}/" })
    public ResponseEntity putSongByIdMethod() {
        return null;
    }

    @PatchMapping({ "/{id}", "/{id}/" })
    public ResponseEntity patchSongByIdMethod() {
        return null;
    }

    @DeleteMapping({ "/{id}", "/{id}/" })
    public ResponseEntity deleteSongByIdMethod() {
        return null;
    }
}
