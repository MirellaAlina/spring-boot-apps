package ar.com.ada.online.second.tpp.model.mapper;

import ar.com.ada.online.second.tpp.model.dto.MovieDTO;
import ar.com.ada.online.second.tpp.model.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper extends DataMapper<MovieDTO, Movie>{

    MovieMapper MAPPER = Mappers.getMapper(MovieMapper.class);
}
