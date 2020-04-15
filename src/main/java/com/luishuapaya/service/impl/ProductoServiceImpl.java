package com.luishuapaya.service.impl;

import java.util.List;
import java.util.Optional;

import com.luishuapaya.model.Producto;
import com.luishuapaya.repo.IProductoRepo;
import com.luishuapaya.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepo producto;

    @Override
    public Producto registrar(Producto obj) {
        return producto.save(obj);
    }

    @Override
    public Producto modificar(Producto obj) {
        return producto.save(obj);
    }

    @Override
    public List<Producto> listar() {
        return producto.findAll();
    }

    @Override
    public Producto listarPorId(Integer id) {
        Optional<Producto> op = producto.findById(id);
        return  op.isPresent()?op.get():new Producto();
    }

    @Override
    public boolean eliminar(Integer id) {
        producto.deleteById(id);
        return true;
    }

}