package br.ufscar.dc.dsw.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.dao.IConsultaDAO;
import br.ufscar.dc.dsw.dao.IUserDAO;
import br.ufscar.dc.dsw.service.spec.IConsultaService;
import br.ufscar.dc.dsw.service.spec.IMedicoService;

@Controller
@RequestMapping("/medico")
public class MedicoController {
	
	@Autowired
	private IConsultaService cService;
	
	@Autowired
	private IMedicoService mService;
	
	@Autowired
	private IUserDAO uDAO;
	
	@GetMapping("/index")
	public String listar(ModelMap model, Principal principal) {
		String email = principal.getName();
		model.addAttribute("consultas", cService.buscarPorMedicoEmail(email));
		
		return "medico/index";
	}
}