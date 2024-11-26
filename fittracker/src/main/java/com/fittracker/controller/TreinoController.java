package com.fittracker.controller;

import com.fittracker.model.Status;
import com.fittracker.model.Treino;
import com.fittracker.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @GetMapping
    public List<Treino> listarTodos() {
        return treinoService.listarTodos();
    }

    @PostMapping
    public Treino adicionar(@RequestBody Treino treino) {
        return treinoService.adicionar(treino);
    }

    @GetMapping("/{id}")
    public Optional<Treino> consultarPorId(@PathVariable Long id) {
        return treinoService.consultarPorId(id);
    }

    @GetMapping("/status/{status}")
    public List<Treino> consultarPorStatus(@PathVariable Status status) {
        return treinoService.consultarPorStatus(status);
    }

    @PutMapping("/{id}")
    public Treino atualizar(@PathVariable Long id, @RequestBody Treino treino) {
        return treinoService.atualizar(id, treino);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        treinoService.remover(id);
    }

    @PatchMapping("/{id}/status")
    public Treino atualizarStatus(@PathVariable Long id, @RequestParam Status status) {
        return treinoService.atualizarStatus(id, status);
    }
}
