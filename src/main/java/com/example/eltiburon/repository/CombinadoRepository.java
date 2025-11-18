package com.example.eltiburon.repository;

import com.example.eltiburon.model.Combinado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CombinadoRepository extends JpaRepository<Combinado, Long> {
    List<Combinado> findByDisponible(Boolean disponible);
}
