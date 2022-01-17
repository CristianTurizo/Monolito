package Monolito6.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ciudades")
public class CiudadEntidad {

    @Id
    @Column(name = "id_ciudad")
    private int idCiudad;

    @Column(name = "ciudad")
    private String ciudad;
    
}
