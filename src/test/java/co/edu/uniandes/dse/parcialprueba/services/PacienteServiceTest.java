package co.edu.uniandes.dse.parcialprueba.services;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.transaction.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(PacienteService.class)
public class PacienteServiceTest {
    
    @Autowired
	private PacienteService pacienteService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<PacienteEntity> pacienteList = new ArrayList<>();

	/**
	 * Configuración inicial de la prueba.
	 */
	@BeforeEach
	void setUp() {
		clearData();
		insertData();
	}

	/**
	 * Limpia las tablas que están implicadas en la prueba.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from PacienteEntity").executeUpdate();

	}

	/**
	 * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
	 */
	private void insertData() {
		for (int i = 0; i < 3; i++) {
			PacienteEntity pacienteEntity = factory.manufacturePojo(PacienteEntity.class);
			entityManager.persist(pacienteEntity);
			pacienteList.add(pacienteEntity);
		}
	}

	/**
	 * @throws IllegalOperationException 
	 */
	@Test
	void testCreatePaciente() throws IllegalOperationException, EntityNotFoundException {
		PacienteEntity newEntity = factory.manufacturePojo(PacienteEntity.class);
	
		PacienteEntity result = pacienteService.createPaciente(newEntity);
		assertNotNull(result);

		PacienteEntity entity = entityManager.find(PacienteEntity.class, result.getId());

		assertEquals(newEntity.getNombre(), entity.getNombre());
		assertEquals(newEntity.getCorreo(), entity.getCorreo());
		assertEquals(newEntity.getEsAcudiente(), entity.getAcudiente());
		assertEquals(newEntity.getTelefono(), entity.getTelefono());
        assertEquals(newEntity.getAcudiente(), entity.getAcudiente());
        assertEquals(newEntity.getHistoriasClinicas(), entity.getHistoriasClinicas());
	}
	

}
