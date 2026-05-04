package br.com.duxusdesafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.duxusdesafio.dto.TimeRequest;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.ComposicaoTimeRepository;
import br.com.duxusdesafio.repository.IntegranteRepository;
import br.com.duxusdesafio.repository.TimeRepository;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private IntegranteRepository integranteRepository;

    @Autowired
    private ComposicaoTimeRepository composicaoTimeRepository;

    @PostMapping
    public Time cadastrar(@RequestBody TimeRequest request) {

        Time time = new Time();
        time.setNomeDoClube(request.getNomeDoClube());
        time.setData(request.getData());

        time = timeRepository.save(time);

        for (Long integranteId : request.getIntegrantesIds()) {

            Integrante integrante = integranteRepository.findById(integranteId)
                    .orElseThrow(() -> new RuntimeException("Integrante não encontrado"));

            ComposicaoTime composicao = new ComposicaoTime();
            composicao.setTime(time);
            composicao.setIntegrante(integrante);

            composicaoTimeRepository.save(composicao);
        }

        return time;
    }

    @GetMapping
    public List<Time> listar() {
        return timeRepository.findAll();
    }
}