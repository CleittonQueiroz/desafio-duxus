package br.com.duxusdesafio.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;

/**
 * Service que possuirá as regras de negócio para o processamento dos dados
 * solicitados no desafio!
 *
 * OBS ao candidato: PREFERENCIALMENTE, NÃO ALTERE AS ASSINATURAS DOS MÉTODOS!
 * Trabalhe com a proposta pura.
 *
 * @author carlosau
 */ 
@Service
public class ApiService {

    /**
     * Vai retornar um Time, com a composição do time daquela data
     */
    public Time timeDaData(LocalDate data, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
    	// Optei por usar Stream para manter o código organizado, como um fluxo de processo.
    	if (todosOsTimes == null || todosOsTimes.isEmpty() || data == null) {
    	    return null;
    	} 
    	return todosOsTimes.stream() 
    			.filter(time -> data.equals(time.getData()))
    			.findFirst() 
    			.orElse(null);    
    }
    /**
     * Vai retornar o integrante que estiver presente na maior quantidade de times
     * dentro do período
     */
    public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
    	// Processa o fluxo de times, filtro por período opcional, 
    	// e utiliza contagem por agrupamento para encontrar o integrante de maior frequência.

    	if (todosOsTimes == null || todosOsTimes.isEmpty()) {
            return null;
        }
        return todosOsTimes.stream()
                .filter(time -> time.getData() != null)
                .filter(time -> dataInicial == null || !time.getData().isBefore(dataInicial))
                .filter(time -> dataFinal == null || !time.getData().isAfter(dataFinal))
                .flatMap(time -> time.getComposicaoTime().stream())
                .map(composicao -> composicao.getIntegrante())
                .collect(Collectors.groupingBy(integrante -> integrante, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entrada -> entrada.getKey())
                .orElse(null);
    }
    /**
     * Vai retornar uma lista com os nomes dos integrantes do time mais recorrente dentro do período.
     * OBS: Time é o clube + composição em determinada data
     */
    public List<String> integrantesDoTimeMaisRecorrente(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
    	 if (todosOsTimes == null || todosOsTimes.isEmpty()) {
    	        return null;
    	    }
    	    return todosOsTimes.stream()    	   
    	            .filter(time -> time.getData() != null)
    	            .filter(time -> dataInicial == null || !time.getData().isBefore(dataInicial))
    	            .filter(time -> dataFinal == null || !time.getData().isAfter(dataFinal))    	            
    	            .collect(Collectors.groupingBy(
    	                    time -> time.getNomeDoClube() + "|" +
    	                            time.getComposicaoTime().stream()
    	                                    .map(composicao -> composicao.getIntegrante().getNome())
    	                                    .sorted()
    	                                    .collect(Collectors.joining(",")),
    	                    Collectors.counting()))    
    	            .entrySet().stream()
    	            .max(Map.Entry.comparingByValue())    	       
    	            .map(entry -> entry.getKey().split("\\|")[1])    	          
    	            .map(nomes -> Arrays.asList(nomes.split(",")))
    	            .orElse(null);
    	}

    /**
     * Vai retornar a função mais recorrente nos times dentro do período
     */
    public String funcaoMaisRecorrente(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o nome do Clube mais comum dentro do período
     */
    public String clubeMaisRecorrente(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        return null;
    }


    /**
     * Vai retornar o número (quantidade) de aparições de cada Clube participante no período
     */
    public Map<String, Long> contagemDeClubesNoPeriodo(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o número (quantidade) de Funções dentro do período.
     * Dica - pense sobre repetições!
     */
    public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

}
