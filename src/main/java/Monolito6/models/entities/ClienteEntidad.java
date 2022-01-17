package Monolito6.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clientes1")
public class ClienteEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clientes")
    private int idClientes;

    @Column(name = "nombres")
    private String nombre;

    @Column(name = "apellidos")
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "tipo_documento", referencedColumnName = "id_tipo_documento")
    private TipoDocumentoEntidad tipoDocumento;

    @Column(name = "documento")
    private String documento;

    @Column(name = "edad")
    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "ciudad_nacimiento", referencedColumnName = "id_ciudad")
    private CiudadEntidad ciudadNacimiento;

    @Column(name = "imagen_cliente")
    private String idImagen;

    @Transient
    private ImagenMongo imagenMongo;

}
