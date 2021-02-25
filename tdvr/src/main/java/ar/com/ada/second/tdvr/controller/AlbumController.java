package ar.com.ada.second.tdvr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "albums")
public class AlbumController {

    @GetMapping({ "/", "" })
    public ResponseEntity getAlbumsMethod() {
        return null;
    }

    @GetMapping({ "/{id}", "/{id}/" })
    public ResponseEntity getAlbumByIdMethod() {
        return null;
    }

    @PostMapping({ "/", "" })
    public ResponseEntity postAlbumMethod() {
        return null;
    }

    @PutMapping({ "/{id}", "/{id}/" })
    public ResponseEntity putAlbumByIdMethod() {
        return null;
    }

    @PatchMapping({ "/{id}", "/{id}/" })
    public ResponseEntity patchAlbumByIdMethod() {
        return null;
    }

    @DeleteMapping({ "/{id}", "/{id}/" })
    public ResponseEntity deleteAlbumByIdMethod() {
        return null;
    }
}
