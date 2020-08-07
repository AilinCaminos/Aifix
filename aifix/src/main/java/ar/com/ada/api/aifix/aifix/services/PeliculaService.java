package ar.com.ada.api.aifix.aifix.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.aifix.aifix.entities.Pelicula;
import ar.com.ada.api.aifix.aifix.repositories.PeliculaRepository;

@Service
public class PeliculaService {
    
    @Autowired
    PeliculaRepository pRepository;

    public void grabar(Pelicula pelicula) {
        pRepository.save(pelicula);
    }

    public List<Pelicula> listarSeries() {
        return pRepository.findAll();
    }

    public Pelicula buscarSeriePorId(ObjectId id){

        return pRepository.findBy_id(id);
   
    }

}