package com.luishuapaya.service.impl;

import java.util.List;
import java.util.Optional;

import com.luishuapaya.model.Persona;
import com.luishuapaya.repo.IPersonaRepo;
import com.luishuapaya.service.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaRepo persona;

    @Override
    public Persona registrar(Persona obj) {
        return persona.save(obj);
    }

    @Override
    public Persona modificar(Persona obj) {
        return persona.save(obj);
    }

    @Override
    public List<Persona> listar() {
        return persona.findAll();
    }

    @Override
    public Persona listarPorId(Integer id) {
        Optional<Persona> op = persona.findById(id);
        return  op.isPresent()?op.get():new Persona();
    }

    @Override
    public boolean eliminar(Integer id) {
        persona.deleteById(id);
        return true;
    }

}