package co.edu.uniandes.dse.parcialprueba.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

@Data
@Entity
public class PacienteEntity extends BaseEntity {

    private String nombre;
    private String correo;
    private String telefono;
    private Boolean esAcudiente;
  
    @PodamExclude
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<HistoriaClinicaEntity> historiasClinicas = new ArrayList<>();
    @PodamExclude
    @OneToOne(mappedBy = "paciente", fetch = FetchType.LAZY)
    private PacienteEntity acudiente;
}
