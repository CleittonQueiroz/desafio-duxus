package br.com.duxusdesafio.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.TimeRepository;
import br.com.duxusdesafio.service.ApiService;

@RestController
@RequestMapping("/api")
public class ProcessamentoController {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private ApiService apiService;

    private LocalDate converterData(String data) {
        return (data != null && !data.isEmpty()) ? LocalDate.parse(data) : null;
    }

    @GetMapping("/time-da-data")
    public Time timeDaData(@RequestParam String data) {
        return apiService.timeDaData(converterData(data), timeRepository.findAll());
    }

    @GetMapping("/integrantes-do-time-mais-recorrente")
    public List<String> integrantesDoTimeMaisRecorrente(
            @RequestParam(required = false) String dataInicial,
            @RequestParam(required = false) String dataFinal) {

        return apiService.integrantesDoTimeMaisRecorrente(
                converterData(dataInicial),
                converterData(dataFinal),
                timeRepository.findAll());
    }

    @GetMapping("/integrante-mais-usado")
    public Integrante integranteMaisUsado(
            @RequestParam(required = false) String dataInicial,
            @RequestParam(required = false) String dataFinal) {

        return apiService.integranteMaisUsado(
                converterData(dataInicial),
                converterData(dataFinal),
                timeRepository.findAll());
    }

    @GetMapping("/funcao-mais-recorrente")
    public String funcaoMaisRecorrente(
            @RequestParam(required = false) String dataInicial,
            @RequestParam(required = false) String dataFinal) {

        return apiService.funcaoMaisRecorrente(
                converterData(dataInicial),
                converterData(dataFinal),
                timeRepository.findAll());
    }

    @GetMapping("/clube-mais-recorrente")
    public String clubeMaisRecorrente(
            @RequestParam(required = false) String dataInicial,
            @RequestParam(required = false) String dataFinal) {

        return apiService.clubeMaisRecorrente(
                converterData(dataInicial),
                converterData(dataFinal),
                timeRepository.findAll());
    }

    @GetMapping("/contagem-clubes")
    public Map<String, Long> contagemDeClubesNoPeriodo(
            @RequestParam(required = false) String dataInicial,
            @RequestParam(required = false) String dataFinal) {

        return apiService.contagemDeClubesNoPeriodo(
                converterData(dataInicial),
                converterData(dataFinal),
                timeRepository.findAll());
    }

    @GetMapping("/contagem-funcoes")
    public Map<String, Long> contagemPorFuncao(
            @RequestParam(required = false) String dataInicial,
            @RequestParam(required = false) String dataFinal) {

        return apiService.contagemPorFuncao(
                converterData(dataInicial),
                converterData(dataFinal),
                timeRepository.findAll());
    }
}