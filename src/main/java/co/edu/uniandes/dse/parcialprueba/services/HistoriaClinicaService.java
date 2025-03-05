package co.edu.uniandes.dse.parcialprueba.services;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;
import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.repositories.HistoriaClinicaRepository;
import jakarta.transaction.Transactional;

public class HistoriaClinicaService {

    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;
    
    public HistoriaClinicaEntity createHistoriaClinica(HistoriaClinicaEntity historiaClinica) throws IllegalOperationException{
        if(historiaClinica == null){
            throw new IllegalOperationException("La historia clinica no puede ser nula");
        }
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Transactional

    public HistoriaClinicaEntity getHistoriaClinica(Long historiaClinicaId) throws EntityNotFoundException {
        Optional<HistoriaClinicaEntity> historiaClinicaEntity = historiaClinicaRepository.findById(historiaClinicaId);
        if (historiaClinicaEntity.isEmpty())
            throw new EntityNotFoundException("No se encontro la historia clinica con id " + historiaClinicaId);
        return historiaClinicaEntity.get();
    }

    @Transactional
    public List<HistoriaClinicaEntity> getHistoriasClinicas(){
        return historiaClinicaRepository.findAll();
    }

}
