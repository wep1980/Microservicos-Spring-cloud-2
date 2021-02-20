package br.com.waldirdev.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.waldirdev.hrpayroll.entities.Worker;

/**
 * 1 - Para realizar a comunicação entre os projetos e necessario declarar uma interface com a assinatura das requisições que podem ser feitas
 * @FeignClient (url = "localhost:8001") -> Como o projeto tera mais de uma instancia disponivel, essa abordagem não sera mais usada
 * @author wepbi
 *
 */
@Component // Componente gerenciado pelo Spring, vai ser injetado em outras classes
@FeignClient(name = "hr-worker" , path = "/workers")
public interface WorkerFeignClient {
	
	
	// Assinaturas da interface
	
	/*
	 * Como e uma interface o public na assinatura fica redundante
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id);

}
