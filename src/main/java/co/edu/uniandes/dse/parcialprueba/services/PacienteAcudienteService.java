package co.edu.uniandes.dse.parcialprueba.services;

public class PacienteAcudienteService {
    
}




public PacienteEntity addAcudiente(Long pacienteId, Long acudienteId) throws EntityNotFoundException {
    log.info("Inicia proceso de agregarle un acudiente a un paciente", pacienteId);

    Optional<PacienteEntity> paciente = pacienteRepository.findById(pacienteId);
    if (paciente.isEmpty())
        throw new EntityNotFoundException("No se encontro el paciente con id " + pacienteId);

        paciente.get().getAcudiente();
        log.info("Termina proceso de agregarle un acudiente a un paciente", pacienteId);
        return pacienteRepository.get();