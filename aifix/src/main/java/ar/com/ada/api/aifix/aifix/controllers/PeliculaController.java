package ar.com.ada.api.aifix.aifix.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.aifix.aifix.entities.Pelicula;
import ar.com.ada.api.aifix.aifix.models.responses.GenericResponse;
import ar.com.ada.api.aifix.aifix.services.PeliculaService;

@RestController
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @PostMapping("/api/peliculas")
    public ResponseEntity<GenericResponse> crearSerie(@RequestBody Pelicula peliInfo){
        
        peliculaService.grabar(peliInfo);
        GenericResponse response = new GenericResponse();
        response.isOK = true;
        response.message =  "Pelicula creada con exito!";
        response.id= peliInfo.get_id();

        return  ResponseEntity.ok(response);
    }

    @GetMapping("/api/peliculas/{id}")
    public ResponseEntity<Pelicula> buscarSeriePorId(@PathVariable String id){

        ObjectId objId = new ObjectId(id);
        Pelicula pelicula = peliculaService.buscarSeriePorId(objId);

        if(pelicula == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pelicula);
    }
    
}