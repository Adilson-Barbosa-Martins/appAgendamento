package br.edu.infnet.appAgendamento.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appAgendamento.model.domain.Agendamento;

@Service
public class AgendamentoService {
	private Map<Integer, Agendamento> mapa = new HashMap<>();

	public void incluir(Agendamento agendamento) {
		mapa.put(agendamento.getId(), agendamento);
	}

	public Collection<Agendamento> obterLista() {
		return mapa.values();
	}

}
