package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufscar.dc.dsw.service.spec.IMedicoService;

@Controller
public class HomeController {
	
	@Autowired
	private IMedicoService medicoService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("medicos", medicoService.buscarTodos());
		return "medico/lista";
	}
}
