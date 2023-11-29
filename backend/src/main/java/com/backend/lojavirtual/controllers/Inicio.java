package com.backend.lojavirtual.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Inicio {

	@GetMapping("/inicio")
	public String Inicio() {
		return "OLá, Seja bem vindo a loja virtual " + new Date();
	}
}
