package com.fittracker.service;

import com.fittracker.model.Status;
import com.fittracker.model.Treino;
import com.fittracker.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    public List<Treino> listarTodos() {
        return treinoRepository.findAll();
    }

    public Treino adicionar(Treino treino) {
        return treinoRepository.save(treino);
    }

    public Optional<Treino> consultarPorId(Long id) {
        return treinoRepository.findById(id);
    }

    public List<Treino> consultarPorStatus(Status status) {
        return treinoRepository.findByStatus(status);
    }

    public Treino atualizar(Long id, Treino treino) {
        if (treinoRepository.existsById(id)) {
            treino.setId(id);
            return treinoRepository.save(treino);
        }
        return null;
    }

    public void remover(Long id) {
        treinoRepository.deleteById(id);
    }

    public Treino atualizarStatus(Long id, Status status) {
        Optional<Treino> treinoOpt = treinoRepository.findById(id);
        if (treinoOpt.isPresent()) {
            Treino treino = treinoOpt.get();
            treino.setStatus(status);
            return treinoRepository.save(treino);
        }
        return null;
    }
}
