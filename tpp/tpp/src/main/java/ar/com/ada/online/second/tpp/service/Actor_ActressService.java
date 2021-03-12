package ar.com.ada.online.second.tpp.service;

import ar.com.ada.online.second.tpp.component.BusinessLogicExceptionComponent;
import ar.com.ada.online.second.tpp.model.dto.ActorActressDTO;
import ar.com.ada.online.second.tpp.model.entity.ActorActress;
import ar.com.ada.online.second.tpp.model.mapper.ActorActressMapper;
import ar.com.ada.online.second.tpp.model.mapper.AvoidingMappingContext;
import ar.com.ada.online.second.tpp.model.repository.ActorActressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Actor_ActressService implements Services<ActorActressDTO, ActorActress> {

    private ActorActressMapper actor_actressMapper = ActorActressMapper.MAPPER;

    @Autowired
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    private AvoidingMappingContext context;

    @Autowired
    private ActorActressRepository actor_actressRepository;


    @Override
    public ActorActressDTO createNew(ActorActressDTO dto) {

        ActorActress actorActress = actor_actressMapper.toEntity(dto, context);

        actor_actressRepository.save(actorActress);

        ActorActressDTO actorActressSaved = actor_actressMapper.toDTO(actorActress,context);

        return actorActressSaved;
    }

    @Override
    public List<ActorActressDTO> getAll() {

        List<ActorActress> actorActressesList = actor_actressRepository.findAll();

        List<ActorActressDTO> actorActressesDTOS = actor_actressMapper.toDTO(actorActressesList, context);

        return actorActressesDTOS;
    }

    @Override
    public ActorActressDTO getById(Long id) {
        Optional<ActorActress> actorActressOptional = actor_actressRepository.findById(id);

        ActorActress actorActress = actorActressOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Actor_Actress", id));

        ActorActressDTO actorActressDTO = actor_actressMapper.toDTO(actorActress, context);

        return actorActressDTO;
    }

    @Override
    public ActorActressDTO update(ActorActressDTO dto, Long id) {

        Optional<ActorActress> actorActressOptional = actor_actressRepository.findById(id);

        ActorActress actorActressById = actorActressOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Actor_Actress", id));

        mergeData(actorActressById, dto);

        actor_actressRepository.save(actorActressById);

        ActorActressDTO actorActressUpdated = actor_actressMapper.toDTO(actorActressById, context);

        return actorActressUpdated;
    }

    @Override
    public void remove(Long id) {

        Optional<ActorActress> actorActressByIdToDelete = actor_actressRepository.findById(id);

        ActorActress actorActress = actorActressByIdToDelete
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Actor_Actress", id));

        actor_actressRepository.deleteById(id);
    }

    @Override
    public void mergeData(ActorActress entity, ActorActressDTO dto) {
        if (dto.hasNullOrEmptyAttributes())
            throw logicExceptionComponent.getExceptionEntityEmptyValues("Actor_Actress");

        if (!entity.getFullName().equals(dto.getFullName()))
            entity.setFullName(dto.getFullName());

        if (!entity.getFullName().equals(dto.getFullName()))
            entity.setFullName(dto.getFullName());

        if (!entity.getBirthday().equals(dto.getBirthday()))
            entity.setBirthday(dto.getBirthday());

        if (!entity.getGender().equals(dto.getGender()))
            entity.setGender(dto.getGender());

        if (!entity.getPhotoURL().equals(dto.getPhotoURL()))
            entity.setPhotoURL(dto.getPhotoURL());
    }
}
