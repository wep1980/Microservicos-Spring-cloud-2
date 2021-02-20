package br.com.waldirdev.hrpayroll.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Classe de configuração que disponibiliza um Bean, que é uma instancia unica que fica disponivel no projeto.
 * O PROJETO PAYROLL NÃO UTILIZA BANCO DE DADOS, OU SEJA NÃO UTILIZA JPA
 * @author wepbi
 *
 */
@Configuration
public class AppConfig {
	
	
	/**
	 * Metodo que registra uma instancia unica, um singleton(Padrão de projeto) de um objeto RestTemplate.
	 * Essa instancia fica disponivel para injetar em outros componentes.
	 * Componente criado a partir de uma chamada de metodo.
	 * @return uma instancia do RestTemplate()
	 */
	@Bean
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}

}
