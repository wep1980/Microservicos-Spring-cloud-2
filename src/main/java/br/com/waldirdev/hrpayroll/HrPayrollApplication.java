package br.com.waldirdev.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 1 - Para realizar a comunicação entre os projetos e necessario declarar uma interface com a assinatura das requisições que podem ser feitas
 * @author wepbi
 *
 */
@EnableFeignClients // Diponilibiliza o FEIGN no projeto
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
