package com.example.eltiburon.controller;

import com.example.eltiburon.model.Combinado;
import com.example.eltiburon.service.CombinadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/combinados")
public class CombinadoController {

    private final CombinadoService service;

    public CombinadoController(CombinadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Combinado> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Combinado buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Combinado crear(@RequestBody Combinado combinado) {
        return service.crear(combinado);
    }

    @PutMapping("/{id}")
    public Combinado actualizar(@PathVariable Long id, @RequestBody Combinado combinado) {
        return service.actualizar(id, combinado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/disponibles")
    public List<Combinado> disponibles() {
        return service.buscarDisponibles();
    }
}
