//package ar.com.ada.second.tdvr.service;
//
//
//import ar.com.ada.second.tdvr.model.dto.SongDTO;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class SongService implements Services<SongDTO> {
//
//
//    @Override
//    public SongDTO createNew(SongDTO dto) {
//        return null;
//    }
//
//    @Override
//    public List<SongDTO> getAll() {
//        return null;
//    }
//
//    @Override
//    public SongDTO getById(Long id) {
//        return null;
//    }
//
//    @Override
//    public SongDTO update(SongDTO dto, Long id) {
//        return null;
//    }
//
//    @Override
//    public void remove(Long id) {
//
//    }
//
//    @Override
//    public void mergeData(Object entity, Object dto) {
//        if (dto.hasNullOrEmptyAttributes())
//            throw logicExceptionComponent.getExceptionEntityEmptyValues("Song");
//
//        if (!entity.getName().equals(dto.getName()))
//            entity.setName(dto.getName());
//    }
//}
