package Monolito6.models.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Document(value = "Imagen")
public class ImagenMongo {

    @Id
    private String id;

    @Column(name = "imagen")
    private String imagen;

}
