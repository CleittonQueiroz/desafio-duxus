package br.com.duxusdesafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.repository.IntegranteRepository;

@RestController
@RequestMapping("/integrantes")
public class IntegranteController {

    @Autowired
    private IntegranteRepository integranteRepository;

    @PostMapping
    public Integrante cadastrar(@RequestBody Integrante integrante) {
        return integranteRepository.save(integrante);
    }

    @GetMapping
    public List<Integrante> listarTodos() {
        return integranteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Integrante buscarPorId(@PathVariable Long id) {
        return integranteRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        integranteRepository.deleteById(id);
    }
}