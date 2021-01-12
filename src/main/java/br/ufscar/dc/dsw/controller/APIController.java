package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.service.spec.IMedicoService;
import br.ufscar.dc.dsw.service.spec.IPacienteService;

@CrossOrigin
@RestController
public class APIController {
	
	@Autowired
	private IMedicoService medicoService;
	
	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	 }
	
	private void parseMedico(Medico medico, JSONObject json) {
	
		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				medico.setId(((Integer) id).longValue());
			} else {
				medico.setId((Long) id);
			}
		}
		
		medico.setUsername((String) json.get("username"));
		medico.setPassword((String) json.get("password"));
		medico.setCrm((String) json.get("crm"));
		medico.setEspecialidade(Medico.Especialidades.values()[(Integer) json.get("especialidade")]);
		medico.setNome((String) json.get("nome"));
		medico.setRole("ROLE_MEDICO");
		medico.setEnabled(true);
	}
	
	private void parsePaciente(Paciente paciente, JSONObject json) {
		
		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				paciente.setId(((Integer) id).longValue());
			} else {
				paciente.setId((Long) id);
			}
		}
		
		paciente.setUsername((String) json.get("username"));
		paciente.setPassword((String) json.get("password"));
		paciente.setCpf((String) json.get("cpf"));
		paciente.setSexo(Paciente.Sexos.values()[(Integer) json.get("sexo")]);
		paciente.setNome((String) json.get("nome"));
		paciente.setTelefone((String) json.get("telefone"));
		paciente.setDia((Integer) json.get("dia"));
		paciente.setMes((Integer) json.get("mes"));
		paciente.setAno((Integer) json.get("ano"));
		paciente.setRole("ROLE_PACIENTE");
		paciente.setEnabled(true);
	}
	
	@GetMapping(path = "/medicos")
	public ResponseEntity<List<Medico>> lista() {
		List<Medico> lista = medicoService.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	 }
	
	@GetMapping(path = "/medicos/{id}")
	public ResponseEntity<Medico> lista(@PathVariable("id") long id) {
		Medico medico = medicoService.buscarPorId(id);
		if (medico == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(medico);
	}
	
	@PostMapping(path = "/medicos")
	@ResponseBody
	public ResponseEntity<Medico> cria(@RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Medico medico = new Medico();
				parseMedico(medico, json);
				medicoService.salvar(medico);
				return ResponseEntity.ok(medico);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}
	
	@PutMapping(path = "/medicos/{id}")
	public ResponseEntity<Medico> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Medico medico = medicoService.buscarPorId(id);
				if (medico == null) {
					return ResponseEntity.notFound().build();
				} else {
					parseMedico(medico, json);
					medicoService.salvar(medico);
					return ResponseEntity.ok(medico);
				}
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}
	
	@DeleteMapping(path = "/medicos/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {

		Medico medico = medicoService.buscarPorId(id);
		if (medico == null) {
			return ResponseEntity.notFound().build();
		} else {
			medicoService.excluir(id);
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping(path = "/pacientes")
	public ResponseEntity<List<Paciente>> lista1() {
		List<Paciente> lista = pacienteService.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	 }
	
	@GetMapping(path = "/pacientes/{id}")
	public ResponseEntity<Paciente> lista1(@PathVariable("id") long id) {
		Paciente paciente = pacienteService.buscarPorId(id);
		if (paciente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(paciente);
	}
	
	@PostMapping(path = "/pacientes")
	@ResponseBody
	public ResponseEntity<Paciente> cria1(@RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Paciente paciente = new Paciente();
				parsePaciente(paciente, json);
				pacienteService.salvar(paciente);
				return ResponseEntity.ok(paciente);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}
	
	@PutMapping(path = "/pacientes/{id}")
	public ResponseEntity<Paciente> atualiza1(@PathVariable("id") long id, @RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Paciente paciente = pacienteService.buscarPorId(id);
				if (paciente == null) {
					return ResponseEntity.notFound().build();
				} else {
					parsePaciente(paciente, json);
					pacienteService.salvar(paciente);
					return ResponseEntity.ok(paciente);
				}
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}
	
	@DeleteMapping(path = "/pacientes/{id}")
	public ResponseEntity<Boolean> remove1(@PathVariable("id") long id) {

		Paciente paciente = pacienteService.buscarPorId(id);
		if (paciente == null) {
			return ResponseEntity.notFound().build();
		} else {
			pacienteService.excluir(id);
			return ResponseEntity.noContent().build();
		}
	}

}