package com.fittracker.repository;


import com.fittracker.model.Status;
import com.fittracker.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
    List<Treino> findByStatus(Status status);
}
