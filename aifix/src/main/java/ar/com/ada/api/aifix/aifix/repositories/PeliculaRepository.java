package ar.com.ada.api.aifix.aifix.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.aifix.aifix.entities.Pelicula;

@Repository
public interface PeliculaRepository extends MongoRepository<Pelicula, ObjectId> {

    Pelicula findBy_id(ObjectId id);

    Pelicula findByNombre(String nombre);

}