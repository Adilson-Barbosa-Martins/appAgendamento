package br.edu.infnet.appAgendamento.model.domain;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Profissional extends Usuario {
	private String especialidade;
	private List<Agendamento> agendamentosList;

	public Profissional() {
		agendamentosList = new ArrayList<>();
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public List<Agendamento> getAgendamentosList() {
		return agendamentosList;
	}

	public void setAgendamentosList(List<Agendamento> agendamentosList) {
		this.agendamentosList = agendamentosList;
	}

	@Override
	public String toString() {
		return super.toString() + " - Especialidade: " + especialidade +
				" - AgendamentosList: " + agendamentosList;
	}

}

