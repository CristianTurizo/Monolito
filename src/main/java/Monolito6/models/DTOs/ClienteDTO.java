package Monolito6.models.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
public class ClienteDTO {

    @JsonProperty("idClientes")
    private int idClientes;

    @NotBlank(message = "Campo Vacio")
    @JsonProperty("nombre")
    private String nombre;

    @NotBlank(message = "Campo Vacio")
    @JsonProperty("apellido")
    private String apellido;

    @Valid
    @NotNull
    @JsonProperty("tipoDocumento")
    private TipoDocumentoDTO tipoDocumento;

    @NotBlank(message = "Campo Vacio")
    @Size(min = 8, max = 10, message = "El documento debe tener entre 8 y 10 digitos")
    @JsonProperty("documento")
    private String documento;

    @NotNull
    @Positive(message = "La edad debe ser mayor que 0")
    @JsonProperty("edad")
    private Integer edad;

    @NotNull
    @JsonProperty("ciudadNacimiento")
    private CiudadDTO ciudadNacimiento;

    @JsonProperty("idImagen")
    private String idImagen;

    @Valid
    @NotNull
    @JsonProperty("imagenMongo")
    private ImagenDTO imagenMongo;

}
