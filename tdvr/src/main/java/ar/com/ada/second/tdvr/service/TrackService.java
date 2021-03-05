package ar.com.ada.second.tdvr.service;


import ar.com.ada.second.tdvr.component.BusinessLogicExceptionComponent;
import ar.com.ada.second.tdvr.model.dto.AlbumDTO;
import ar.com.ada.second.tdvr.model.dto.TrackDTO;
import ar.com.ada.second.tdvr.model.entity.Album;
import ar.com.ada.second.tdvr.model.entity.Track;
import ar.com.ada.second.tdvr.model.mapper.AvoidingMappingContext;
import ar.com.ada.second.tdvr.model.mapper.TrackMapper;
import ar.com.ada.second.tdvr.model.repository.AlbumRepository;
import ar.com.ada.second.tdvr.model.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService implements Services<TrackDTO, Track> {

    private TrackMapper trackMapper =  TrackMapper.MAPPER;

    @Autowired
    private BusinessLogicExceptionComponent logicExceptionComponent;


    @Autowired
    private AvoidingMappingContext context;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public TrackDTO createNew(TrackDTO dto) {
        return null;
    }

    public TrackDTO createNew(TrackDTO dto,Long id) {
        Album album = albumRepository
                .findById(id)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Album", id));

        Track trackToSave = trackMapper.toEntity(dto, context);

        trackToSave.setAlbum(album);

        trackRepository.save(trackToSave);

        TrackDTO trackSaved = trackMapper.toDTO(trackToSave, context);

        return trackSaved;
    }


    @Override
    public List<TrackDTO> getAll() {
        List<Track> trackList =trackRepository.findAll();

        List<TrackDTO> trackDTO = trackMapper.toDTO(trackList, context);

        return trackDTO;
    }

    @Override
    public TrackDTO getById(Long id) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        Track track = trackOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Track", id));

        TrackDTO trackDTO = trackMapper.toDTO(track, context);

    return trackDTO;
    }

    @Override
    public TrackDTO update(TrackDTO dto, Long id) {
        // verifico si el id existe en la base de datos
        Optional<Track> trackOptional = trackRepository.findById(id);

        Track trackById = trackOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Track", id));

        mergeData(trackById, dto);

        trackRepository.save(trackById);

        TrackDTO trackUpdated = trackMapper.toDTO(trackById, context);

        return trackUpdated;
    }

    @Override
    public void remove(Long id) {
        Optional<Track> trackByIdToDelete = trackRepository.findById(id);

        Track track = trackByIdToDelete
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Track", id));

        trackRepository.delete(track);
    }

    @Override
    public void mergeData(Track entity, TrackDTO dto) {
        if (dto.hasNullOrEmptyAttributes())
            throw logicExceptionComponent.getExceptionEntityEmptyValues("Track");

        if (!entity.getTitle().equals(dto.getTitle()))
            entity.setTitle(dto.getTitle());

        if (!entity.getTrackDuration().equals(dto.getTrackDuration()))
            entity.setTrackDuration(dto.getTrackDuration());
    }


    public TrackDTO update(TrackDTO dto, Long albumId, Long trackId) {

        Album albumByIdFromDB = albumRepository
                .findById(albumId)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Album", albumId));


        Track trackByIdFromDB = trackRepository
                .findById(trackId)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Track", trackId));

        trackByIdFromDB.setAlbum(albumByIdFromDB);

        mergeData(trackByIdFromDB, dto);

        trackRepository.save(trackByIdFromDB);

        TrackDTO trackUpdated = trackMapper.toDTO(trackByIdFromDB, context);

        return trackUpdated;

    }
}

