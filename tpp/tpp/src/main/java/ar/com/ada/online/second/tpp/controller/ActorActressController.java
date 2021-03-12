package ar.com.ada.online.second.tpp.controller;

import ar.com.ada.online.second.tpp.model.dto.ActorActressDTO;
import ar.com.ada.online.second.tpp.service.Actor_ActressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "actors_actresses")
public class ActorActressController {

    @Autowired
    private Actor_ActressService actor_actressService;


    @GetMapping({ "/", "" })
    public ResponseEntity getActor_ActressMethod(){

        List<ActorActressDTO> actors_actresses = actor_actressService.getAll();

        return ResponseEntity
                .ok()
                .body(actors_actresses);
    }

    @GetMapping({ "/{id}", "/{id}/" })
    public ResponseEntity getActor_ActressByIdMethod(@PathVariable Long id){

        ActorActressDTO byId = actor_actressService.getById(id);

        return ResponseEntity
                .ok()
                .body(byId);
    }

    @PostMapping({ "/", "" })
    public ResponseEntity postActor_ActressMethod(@Valid @RequestBody ActorActressDTO dto) throws URISyntaxException {

        ActorActressDTO newActorActress = actor_actressService.createNew(dto);

        URI uri = new URI("/actor_actress/" + newActorActress.getId());

        return ResponseEntity
                .created(uri)
                .body(newActorActress);
    }

    @PatchMapping({ "/{id}", "/{id}/" })
    public ResponseEntity patchActor_ActressByIdMethod(@RequestBody ActorActressDTO dto, @PathVariable Long id){

        ActorActressDTO actorActressUpdated = actor_actressService.update(dto, id);

        return ResponseEntity
                .ok()
                .body(actorActressUpdated);
    }

    @DeleteMapping({ "/{id}", "/{id}/" })
    public ResponseEntity deleteActor_ActressByIdMethod(@PathVariable Long id){

        actor_actressService.remove(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
