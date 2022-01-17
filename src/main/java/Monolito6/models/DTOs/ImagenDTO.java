package Monolito6.models.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ImagenDTO {

    @JsonProperty("idImagen")
    private String id;

    @NotBlank(message = "Campo Vacio")
    @JsonProperty("imagen")
    private String imagen;

}
