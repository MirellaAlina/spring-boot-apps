package ar.com.ada.online.second.tpp.model.mapper;

import ar.com.ada.online.second.tpp.model.dto.ActorActressDTO;
import ar.com.ada.online.second.tpp.model.entity.ActorActress;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ActorActressMapper extends DataMapper<ActorActressDTO, ActorActress>{

    ActorActressMapper MAPPER = Mappers.getMapper(ActorActressMapper.class);
}
