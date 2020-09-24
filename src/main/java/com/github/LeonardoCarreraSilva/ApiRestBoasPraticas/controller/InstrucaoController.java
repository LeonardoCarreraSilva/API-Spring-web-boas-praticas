package com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InstrucaoController {
	@GetMapping
	public String mensagem(){
		return "Para a utilização dessa api devemos utilizar algum programa que faça requisições REST,"
				+ "\n"
				+ "como https://insomnia.rest/ ou https://www.postman.com/"
				+ "\n"
				+ "Feito a instação de um desses programas poderemos fazer as seguintes requisições"
				+ "\n"
				+ "\n"
				+ "1- http://localhost:8080/pessoa com metodo GET"
				+ "\n"
				+ "2- http://localhost:8080/pessoa/2 com metodo GET"
				+ "\n"
				+ "3- http://localhost:8080/pessoa com metodo POST com o seguinte json"
				+ "\n"
				+ "{"
				+ "	\"nome\":\"Anderson\",\n"
				+ "	\"sobrenome\":\"Silveira\",\n"
				+ "	\"sexo\":\"M"
				+ "\n}"
				+ "\n"
				+ "4- http://localhost:8080/pessoa/2 com o metodo PUT com o mesmo json alterando a inforções que queira"
				+ "\n"
				+ "5- http://localhost:8080/pessoa/2 com o metodo DELETE para excluir a pessoa com id 2";	
	}
}
