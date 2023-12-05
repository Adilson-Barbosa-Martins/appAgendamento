package br.edu.infnet.appAgendamento.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appAgendamento.model.domain.Usuario;

@Service
public class UsuarioService {
	private static Map<String, Usuario> mapa = new HashMap<>();

	public void incluir(Usuario usuario) {
		mapa.put(usuario.getNome(), usuario);
	}

	public static Collection<Usuario> obterLista() {
		return mapa.values();
	}
}
