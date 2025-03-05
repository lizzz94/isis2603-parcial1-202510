package co.edu.uniandes.dse.parcialprueba.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.parcialprueba.entities.AcudienteEntity;

@Repository
public interface AcudienteRepository extends JpaRepository<AcudienteEntity, Long> {
    Optional<AcudienteEntity> findById(Long id);

}

