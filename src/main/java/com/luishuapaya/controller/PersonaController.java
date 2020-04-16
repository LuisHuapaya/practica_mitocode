package com.luishuapaya.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.luishuapaya.exception.ModeloNotFoundException;
import com.luishuapaya.model.Persona;
import com.luishuapaya.service.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>> listar(){
        List<Persona> lista = service.listar();
        return new ResponseEntity<List<Persona>>(lista,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id){
        Persona p = service.listarPorId(id);
        if(p.getIdPersona() == null) throw new ModeloNotFoundException("Persona no encontrada: " + id);
        return new ResponseEntity<Persona>(p, HttpStatus.OK);
    }
    /*
    @PostMapping
    public ResponseEntity<Persona> registrar(@Valid @RequestBody Persona persona){
        Persona p = service.registrar(persona);
        return new ResponseEntity<Persona>(p,HttpStatus.CREATED);
    }
    */

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Persona persona){
        Persona p = service.registrar(persona);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdPersona()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Persona> modificar(@Valid @RequestBody Persona persona){
        Persona p = service.modificar(persona);
        return new ResponseEntity<Persona>(p,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Persona p = service.listarPorId(id);
        if(p.getIdPersona() == null) throw new ModeloNotFoundException("Persona no existe: " + id);
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

}