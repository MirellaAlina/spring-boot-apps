package ar.com.ada.second.tdvr.controller;

import ar.com.ada.second.tdvr.model.dto.TrackDTO;
import ar.com.ada.second.tdvr.model.entity.Track;
import ar.com.ada.second.tdvr.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping({ "/tracks", "/tracks/" })
    public ResponseEntity getSongsMethod() {
        List<TrackDTO> tracks = trackService.getAll();

        return ResponseEntity
                .ok()
                .body(tracks);
    }

    @GetMapping({ "/tracks/{id}", "/tracks/{id}/" })
    public ResponseEntity getATrackByIdMethod(@PathVariable Long id) {
        TrackDTO byId = trackService.getById(id);

    return ResponseEntity
            .ok()
            .body(byId);
    }

    @PostMapping({"/albums/{albumId}/tracks", "/albums/{albumId}/tracks/"})
    public ResponseEntity postTracktMethod(
            @Valid @PathVariable TrackDTO dto,
            @PathVariable Long albumId) throws URISyntaxException {

        TrackDTO trackSaved = trackService.createNew(dto, albumId);

        URI uri = new URI("/album/" + trackSaved.getId());

        return ResponseEntity
                .created(uri)
                .body(trackSaved);
    }

    @PatchMapping({"/albums/{albumId}/tracks/{trackId}", "/albums/{albumId}/tracks/{trackId}/"})
    public ResponseEntity patchTrackByIdMethod(
            @RequestBody TrackDTO dto,
            @PathVariable Long artistId,
            @PathVariable Long albumId) {

        TrackDTO trackUpdated = trackService.update(dto, artistId, albumId);

        return ResponseEntity
                .ok()
                .body(trackUpdated);
    }

    @DeleteMapping({"/tracks/{id}", "/tracks/{id}/"})
    public ResponseEntity deleteTrackByIdMethod(@PathVariable Long id) {
        trackService.remove(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
