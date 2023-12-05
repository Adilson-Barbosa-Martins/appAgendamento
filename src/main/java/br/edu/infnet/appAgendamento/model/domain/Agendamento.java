package br.edu.infnet.appAgendamento.model.domain;

import java.time.LocalDateTime;

public class Agendamento {
	private int id;
	private LocalDateTime data;
	private Cliente cliente;
	private Profissional profissional;

	public Agendamento() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	@Override
	public String toString() {
		return "Agendamento{" +
				"id=" + id +
				", data=" + data +
				", cliente=" + cliente +
				", profissional=" + profissional +
				'}';
	}

}

