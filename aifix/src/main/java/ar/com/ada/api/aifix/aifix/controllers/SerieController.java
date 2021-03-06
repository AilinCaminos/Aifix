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

import ar.com.ada.api.aifix.aifix.entities.Serie;
import ar.com.ada.api.aifix.aifix.models.responses.GenericResponse;
import ar.com.ada.api.aifix.aifix.services.SerieService;

@RestController
public class SerieController {
    
    @Autowired
    SerieService serieService;

    @PostMapping("/api/series")
    public ResponseEntity<GenericResponse> crearSerie(@RequestBody Serie serieInfo){
        
        serieService.grabar(serieInfo);
        GenericResponse response = new GenericResponse();
        response.isOK = true;
        response.message =  "Serie creada con exito!";
        response.id= serieInfo.get_id();

        return  ResponseEntity.ok(response);
    }
    
    @GetMapping("/api/series")
    public ResponseEntity<List<Serie>> listarSeries(){

        return ResponseEntity.ok(serieService.listarSeries());
    }

    @GetMapping("/api/series/{id}")
    public ResponseEntity<Serie> buscarSeriePorId(@PathVariable String id){

        ObjectId objId = new ObjectId(id);
        Serie serie = serieService.buscarSeriePorId(objId);

        if(serie == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(serie);
    }
}