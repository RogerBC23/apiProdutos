package com.nttdata.controleestoque.produtos.estudosSpringProdutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EstudosSpringProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudosSpringProdutosApplication.class, args);
	}


	@GetMapping("/")
	public String teste(){
		return "Testando Produtos";

	}

}
