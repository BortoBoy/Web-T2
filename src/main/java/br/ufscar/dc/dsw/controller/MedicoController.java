package br.ufscar.dc.dsw.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.service.spec.IMedicoService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private IMedicoService medicoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Medico medico) {
		return "medico/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("medicos", medicoService.buscarTodos());
		return "medico/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Medico medico, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "medico/cadastro";
		}

		medicoService.salvar(medico);
		attr.addFlashAttribute("sucess", "Medico inserido com sucesso");
		return "redirect:/medicos/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("medico", medicoService.buscarPorId(id));
		return "medico/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Medico medico, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "medico/cadastro";
		}

		medicoService.salvar(medico);
		attr.addFlashAttribute("sucess", "Medico editado com sucesso.");
		return "redirect:/medicos/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		medicoService.excluir(id);
		attr.addFlashAttribute("sucess", "Medico excluído com sucesso.");
		return "redirect:/medicos/listar";
	}
//
//	@ModelAttribute("editoras")
//	public List<Editora> listaEditoras() {
//		return editoraService.buscarTodos();
//	}
}
