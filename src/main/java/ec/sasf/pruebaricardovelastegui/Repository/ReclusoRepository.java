package ec.sasf.pruebaricardovelastegui.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.sasf.pruebaricardovelastegui.Entity.Recluso;

@Repository
public interface ReclusoRepository extends JpaRepository<Recluso, Long>{

    Recluso findByNombre(String nombre);
    Optional<Recluso> findById(Long id);
    
}
