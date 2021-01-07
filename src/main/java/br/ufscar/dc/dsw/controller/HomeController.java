package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.service.spec.IMedicoService;

@Controller
public class HomeController {
	
	@Autowired
	private IMedicoService medicoService;
	
	@GetMapping("/")
	public String home(@RequestParam(required=false) String filter, ModelMap model) {
		System.out.println(filter);
		if("Todos".equals(filter) || filter == "" || filter == null) {
			model.addAttribute("medicos", medicoService.buscarTodos());
		}
		else {
			model.addAttribute("medicos", 
			medicoService.buscarPorEspecialidade(Medico.Especialidades.valueOf(filter)));
		}
		model.addAttribute("especialidades", Medico.Especialidades.values());
		model.addAttribute("current_filter", filter);
		return "home";
	}
	
}
