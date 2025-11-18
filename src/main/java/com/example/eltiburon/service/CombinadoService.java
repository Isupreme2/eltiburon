package com.example.eltiburon.service;

import com.example.eltiburon.model.Combinado;
import com.example.eltiburon.repository.CombinadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombinadoService {

    private final CombinadoRepository repository;

    public CombinadoService(CombinadoRepository repository) {
        this.repository = repository;
    }

    public List<Combinado> listarTodos() {
        return repository.findAll();
    }

    public Optional<Combinado> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Combinado crear(Combinado combinado) {
        return repository.save(combinado);
    }

    public Combinado actualizar(Long id, Combinado combinadoNuevo) {
        return repository.findById(id).map(c -> {
            c.setNombre(combinadoNuevo.getNombre());
            c.setDescripcion(combinadoNuevo.getDescripcion());
            c.setPrecio(combinadoNuevo.getPrecio());
            c.setDisponible(combinadoNuevo.getDisponible());
            c.setCategoria(combinadoNuevo.getCategoria());
            return repository.save(c);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public List<Combinado> buscarDisponibles() {
        return repository.findByDisponible(true);
    }
}
