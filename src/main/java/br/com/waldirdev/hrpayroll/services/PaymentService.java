package br.com.waldirdev.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.waldirdev.hrpayroll.entities.Payment;
import br.com.waldirdev.hrpayroll.entities.Worker;
import br.com.waldirdev.hrpayroll.feignclients.WorkerFeignClient;

/**
 *  O PROJETO PAYROLL NÃO UTILIZA BANCO DE DADOS, OU SEJA NÃO UTILIZA JPA
 *  Feign -> forma alternativa de comunicar um projeto com o outro e ja esta integrado com as ferramentas do Spring Cloud
 * @author wepbi
 *
 */
@Service
public class PaymentService {

	
	//@Value("${hr-worker.host}") // Pegando o valor da propriedade host criada no application.properties
	//private String workerHost;
	
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	
	/**
	 * Se utiliza o Map<> para passar parametros em uma requisição RestTemplate utilizando getForObject()
	 * Map<> -> Coleção de pares, chave e valor. O Map<> e uma interface, para ser instanciado e necessario uma classe concreta, no caso o HashMap<>()
	 * ""+workerId -> convertendo de Long para String
	 * @param workerId
	 * @param days
	 * @return
	 */
	public Payment getPayment(Long workerId, int days) {
		
		// MAPA DE PARAMETROS
		//Map<String , String> uriVariables = new HashMap<>(); // Variaveis da uri
		//uriVariables.put("id" , ""+workerId); // a chave e o "id" do trabalhador que sera passado na requisição e o valor é workerId
		
		/*
		 * restTemplate -> Objeto que faz a chamada no webservice de worker.
		 * getForObject() -> Matodo para requisição GET
		 * Worker -> Esta classe foi copiada do projeto Worker.
		 *  workerHost + "/workers/{id}" -> URL da Requisição
		 *  Worker.class -> Tipo do objeto buscado
		 *  uriVariables -> parametros que estão sendo passados
		 */
		//Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}" , Worker.class , uriVariables);
		Worker worker = workerFeignClient.findById(workerId).getBody(); // Para acessar o objeto Worker dentro do responseEntity e necessario usar 
				
		return new Payment(worker.getName() , worker.getDailyIncome(), days);
	}
}
