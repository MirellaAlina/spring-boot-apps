package ar.com.ada.online.second.tpp.controller;

import ar.com.ada.online.second.tpp.model.dto.ActorActressDTO;
import ar.com.ada.online.second.tpp.model.dto.MovieDTO;
import ar.com.ada.online.second.tpp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "movies")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping({ "/", "" })
    public ResponseEntity getMoviesMethod(){

        List<MovieDTO> movies = movieService.getAll();

        return ResponseEntity
                .ok()
                .body(movies);
    }

    @GetMapping({ "/{id}", "/{id}/" })
    public ResponseEntity getMovieByIdMethod(@PathVariable Long id){

        MovieDTO byId = movieService.getById(id);

        return ResponseEntity
                .ok()
                .body(byId);
    }

    @PostMapping({ "/", "" })
    public ResponseEntity postMovieMethod(@Valid @RequestBody MovieDTO dto) throws URISyntaxException {

        MovieDTO newMovie = movieService.createNew(dto);

        URI uri = new URI("/movie/" + newMovie.getId());

        return ResponseEntity
                .created(uri)
                .body(newMovie);
    }

    @PatchMapping({ "/{id}", "/{id}/" })
    public ResponseEntity patchMovieByIdMethod(@RequestBody MovieDTO dto, @PathVariable Long id){

        MovieDTO movieUpdated = movieService.update(dto, id);

        return ResponseEntity
                .ok()
                .body(movieUpdated);
    }

    @DeleteMapping({ "/{id}", "/{id}/" })
    public ResponseEntity deleteMovieByIdMethod(@PathVariable Long id ){

        movieService.remove(id);

        return ResponseEntity
                .noContent()
                .build();
    }

//    @PutMapping({ "/{id}", "/{id}/" })

}
