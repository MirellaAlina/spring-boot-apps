package ar.com.ada.online.second.tpp.model.repository;

import ar.com.ada.online.second.tpp.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
