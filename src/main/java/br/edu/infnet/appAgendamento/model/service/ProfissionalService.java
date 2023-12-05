package br.edu.infnet.appAgendamento.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appAgendamento.model.domain.Profissional;

@Service
public class ProfissionalService {

	private Map<String, Profissional> profissionais = new HashMap<>();

	public void incluir(Profissional profissional) {
		profissionais.put(profissional.getNome(), profissional);
	}

	public Profissional buscarPorNome(String nome) {
		return profissionais.get(nome);
	}

	public Profissional buscarPorId(int id) {
		return profissionais.get(id);
	}

	public Collection<Profissional> obterLista() {
		return profissionais.values();
	}
}
