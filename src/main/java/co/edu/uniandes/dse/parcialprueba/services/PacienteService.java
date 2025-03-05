package co.edu.uniandes.dse.parcialprueba.services;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import co.edu.uniandes.dse.parcialprueba.exceptions.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PacienteService {
    
    @Autowired
    PacienteRepository pacienteRepository;

    @Transactional
    public PacienteEntity createPaciente (PacienteEntity pacienteEntity) throws EntityNotFoundException, IllegalOperationException {
		log.info("Inicia proceso de creación de un paciente");
		
        if (!pacienteEntity.getTelefono().startsWith("311") || pacienteEntity.getTelefono().startsWith("604"))
            throw new IllegalOperationException("El telefono debe comenzar con 311 o con 604");

        if (pacienteEntity.getTelefono().length() != 11)
            throw new IllegalOperationException("El telefono debe tener 11 digitos");

        if (!pacienteEntity.getEsAcudiente() == true)
            throw new IllegalOperationException("El paciente no puede ser acudiente");

        log.info("Termina proceso de creación del paciente");
		return pacienteRepository.save(pacienteEntity);
	}

    public List<PacienteEntity> getPacientes() {
		log.info("Inicia proceso de consultar los pacientes");
        return pacienteRepository.findAll();
    }

    public PacienteEntity getPaciente(Long pacienteId) throws EntityNotFoundException {

        log.info("Inicia proceso de consultar el paciente con id = {0}", pacienteId);
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(pacienteId);
        if (pacienteEntity.isEmpty())
            throw new EntityNotFoundException("No se encontro el paciente con id " + pacienteId);
        log.info("Termina proceso de consultar el paciente con id = {0}", pacienteId);
        return pacienteEntity.get();
    }

}
