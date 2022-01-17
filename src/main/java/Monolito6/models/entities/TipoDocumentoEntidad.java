package Monolito6.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tipo_documento")
public class TipoDocumentoEntidad {

    @Id
    @Column(name = "id_tipo_documento")
    private int idTipoDocumento;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

}
