package br.ufscar.dc.dsw.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.service.spec.IMedicoService;
import br.ufscar.dc.dsw.service.spec.IPacienteService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IMedicoService medicoService;
	
	@Autowired
	private IPacienteService pacienteService;
	
	@GetMapping("/index")
	public String listar(ModelMap model) {
		
		model.addAttribute("medicos",medicoService.buscarTodos());
		model.addAttribute("pacientes",pacienteService.buscarTodos());
		
		return "admin/index";
	}
	
//	@GetMapping("/cadastrar")
//	public String cadastrar(Compra compra) {
//		compra.setUsuario(this.getUsuario());
//		compra.setData("31/08/2020");
//		//compra.setValor(compra.getLivro().getPreco());
//		return "compra/cadastro";
//	}
//	
//	private Usuario getUsuario() {
//		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		return usuarioDetails.getUser();
//	}
//	
//	
//	@PostMapping("/salvar")
//	public String salvar(Compra compra, BindingResult result, RedirectAttributes attr) {
//		
//		String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
//		compra.setUsuario(this.getUsuario());
//		compra.setData(data);
//		compra.setValor(compra.getLivro().getPreco());
//		
//		service.salvar(compra);
//		attr.addFlashAttribute("sucess", "Compra inserida com sucesso.");
//		return "redirect:/compras/listar";
//	}
//	
//	@ModelAttribute("livros")
//	public List<Livro> listaLivros() {
//		return livroService.buscarTodos();
//	}
}