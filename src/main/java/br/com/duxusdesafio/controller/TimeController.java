package br.com.duxusdesafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.TimeRepository;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeRepository timeRepository;

    @PostMapping
    public Time cadastrar(@RequestBody Time time) {
        return timeRepository.save(time);
    }

    @GetMapping
    public List<Time> listarTodos() {
        return timeRepository.findAll();
    }
}