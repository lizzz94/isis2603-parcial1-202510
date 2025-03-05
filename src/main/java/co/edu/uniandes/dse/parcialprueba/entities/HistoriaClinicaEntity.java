package co.edu.uniandes.dse.parcialprueba.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;
import lombok.Data;

@Data
@Entity
public class HistoriaClinicaEntity extends BaseEntity {
    
    private String diagnostico;
    private String tratamiento;
    private String fechaDeCreacion;

}
