package Monolito6.repositories;

import Monolito6.models.entities.ImagenMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IImagenRepository extends MongoRepository<ImagenMongo, Integer> {
    Optional<ImagenMongo> findById(String id);

    void deleteById(String id);
}
