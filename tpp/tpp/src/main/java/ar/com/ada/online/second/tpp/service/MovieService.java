package ar.com.ada.online.second.tpp.service;

import ar.com.ada.online.second.tpp.component.BusinessLogicExceptionComponent;
import ar.com.ada.online.second.tpp.model.dto.MovieDTO;
import ar.com.ada.online.second.tpp.model.entity.Movie;
import ar.com.ada.online.second.tpp.model.mapper.AvoidingMappingContext;
import ar.com.ada.online.second.tpp.model.mapper.MovieMapper;
import ar.com.ada.online.second.tpp.model.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements Services<MovieDTO, Movie>{

    private MovieMapper movieMapper = MovieMapper.MAPPER;

    @Autowired
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    private AvoidingMappingContext context;

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public MovieDTO createNew(MovieDTO dto) {

        Movie movie = movieMapper.toEntity(dto, context);

        movieRepository.save(movie);

        MovieDTO movieSaved = movieMapper.toDTO(movie, context);

        return movieSaved;
    }

    @Override
    public List<MovieDTO> getAll() {

        List<Movie> moviesList = movieRepository.findAll();

        List<MovieDTO> moviesDTOS = movieMapper.toDTO(moviesList, context);

        return moviesDTOS;
    }

    @Override
    public MovieDTO getById(Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);

        Movie movieById = movieOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Movie", id));

        MovieDTO movieDTO = movieMapper.toDTO(movieById, context);

        return movieDTO;
    }

    @Override
    public MovieDTO update(MovieDTO dto, Long id) {

        Optional<Movie> movieOptional = movieRepository.findById(id);

        Movie movieById = movieOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Movie", id));

        mergeData(movieById, dto);

        movieRepository.save(movieById);

        MovieDTO movieUpdated = movieMapper.toDTO(movieById, context);

        return movieUpdated;
    }

    @Override
    public void remove(Long id) {
        Optional<Movie> movieOptionalByIdToDelete = movieRepository.findById(id);

        Movie movieById = movieOptionalByIdToDelete
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Movie", id));

        movieRepository.deleteById(id);
    }

    @Override
    public void mergeData(Movie entity, MovieDTO dto) {
        if (dto.hasNullOrEmptyAttributes())
            throw logicExceptionComponent.getExceptionEntityEmptyValues("Actor_Actress");

        if (!entity.getTitle().equals(dto.getTitle()))
            entity.setTitle(dto.getTitle());

        if (!entity.getDescription().equals(dto.getDescription()))
            entity.setDescription(dto.getDescription());

        if (!entity.getPosterURL().equals(dto.getPosterURL()))
            entity.setPosterURL(dto.getPosterURL());

        if (!entity.getReleased().equals(dto.getReleased()))
            entity.setReleased(dto.getReleased());

    }
}
