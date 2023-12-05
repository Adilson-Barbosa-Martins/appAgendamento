package br.edu.infnet.appAgendamento.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
	private String numeroCelular;
	private List<Agendamento> historicoAgendamentos;

	public Cliente() {
		historicoAgendamentos = new ArrayList<>();
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public List<Agendamento> getHistoricoAgendamentos() {
		return historicoAgendamentos;
	}

	public void setHistoricoAgendamentos(List<Agendamento> historicoAgendamentos) {
		this.historicoAgendamentos = historicoAgendamentos;
	}

	@Override
	public String toString() {
		return super.toString() + " - NumeroCelular: " + numeroCelular +
				" - HistoricoAgendamentos: " + historicoAgendamentos;
	}

}

