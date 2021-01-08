package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.service.spec.IMedicoService;
import br.ufscar.dc.dsw.service.spec.IPacienteService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IMedicoService medicoService;
	
	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/index")
	public String listar(ModelMap model) {
		
		model.addAttribute("medicos",medicoService.buscarTodos());
		model.addAttribute("pacientes",pacienteService.buscarTodos());
		
		return "admin/index";
	}
	
	@GetMapping("/paciente/criar")
	public String cadastrarPaciente(Paciente paciente,  ModelMap model) {
		model.addAttribute("sexos", Paciente.Sexos.values());
		return "admin/paciente";
	}
	
	@GetMapping("/paciente/editar/{id}")
	public String editarPaciente(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("paciente", pacienteService.buscarPorId(id));
		model.addAttribute("sexos", Paciente.Sexos.values());
		return "admin/paciente";
	}
	
	@PostMapping("/paciente/salvar")
	public String salvarPaciente(@Valid Paciente p, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "admin/paciente/criar";
		}

		pacienteService.salvar(p);
		attr.addFlashAttribute("sucess", "Paciente inserido com sucesso");
		return "redirect:/admin/index";
	}


	@PostMapping("/paciente/editar")
	public String updatePaciente(@Valid Paciente p, BindingResult result, RedirectAttributes attr) {
		
		// do not update this fields
		p.setRole(pacienteService.buscarPorId(p.getId()).getRole());
		p.setEnabled(pacienteService.buscarPorId(p.getId()).isEnabled());
		
		// update password just when it was sent
		if(p.getPassword() == "" || p.getPassword() == null) {
			p.setPassword(pacienteService.buscarPorId(p.getId()).getPassword());
		}
		else {
			p.setPassword(encoder.encode(p.getPassword()));
		}
		
		if (result.hasErrors()) {
			return "admin/paciente/criar";
		}

		pacienteService.salvar(p);
		attr.addFlashAttribute("sucess", "Paciente editado com sucesso.");
		return "redirect:/admin/index";
	}

	@GetMapping("/paciente/excluir/{id}")
	public String excluirPaciente(@PathVariable("id") Long id, RedirectAttributes attr) {
		pacienteService.excluir(id);
		attr.addFlashAttribute("sucess", "Paciente excluído com sucesso.");
		return "redirect:/admin/index";
	}
	
	@GetMapping("/medico/criar")
	public String cadastrarMedico(Medico medico,  ModelMap model) {
		model.addAttribute("especialidades", Medico.Especialidades.values());
		return "admin/medico";
	}
	
	@GetMapping("/medico/editar/{id}")
	public String editarMedico(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("medico", medicoService.buscarPorId(id));
		model.addAttribute("especialidades", Medico.Especialidades.values());
		return "admin/medico";
	}
	
	@PostMapping("/medico/salvar")
	public String salvarMedico(@Valid Medico p, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "admin/medico/criar";
		}

		medicoService.salvar(p);
		attr.addFlashAttribute("sucess", "Medico inserido com sucesso");
		return "redirect:/admin/index";
	}


	@PostMapping("/medico/editar")
	public String updateMedico(@Valid Medico p, BindingResult result, RedirectAttributes attr) {
		
		// do not update this fields
		p.setRole(medicoService.buscarPorId(p.getId()).getRole());
		p.setEnabled(medicoService.buscarPorId(p.getId()).isEnabled());
		
		// update password just when it was sent
		if(p.getPassword() == "" || p.getPassword() == null) {
			p.setPassword(medicoService.buscarPorId(p.getId()).getPassword());
		}
		else {
			p.setPassword(encoder.encode(p.getPassword()));
		}
		
		if (result.hasErrors()) {
			return "admin/medico/criar";
		}

		medicoService.salvar(p);
		attr.addFlashAttribute("sucess", "Medico editado com sucesso.");
		return "redirect:/admin/index";
	}

	@GetMapping("/medico/excluir/{id}")
	public String excluirMedico(@PathVariable("id") Long id, RedirectAttributes attr) {
		medicoService.excluir(id);
		attr.addFlashAttribute("sucess", "Medico excluído com sucesso.");
		return "redirect:/admin/index";
	}

}