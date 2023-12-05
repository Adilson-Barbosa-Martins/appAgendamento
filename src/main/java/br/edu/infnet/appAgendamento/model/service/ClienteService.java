package br.edu.infnet.appAgendamento.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appAgendamento.model.domain.Cliente;


@Service
public class ClienteService {

	private Map<String, Cliente> clientes = new HashMap<>();

	public void incluir(Cliente cliente) {
		clientes.put(cliente.getNome(), cliente);
	}

	public Cliente buscarPorNome(String nome) {
		return clientes.get(nome);
	}
	public Cliente buscarPorId(int id) {
		return clientes.get(id);
	}
	public Collection<Cliente> obterLista() {
		return clientes.values();
	}

}
