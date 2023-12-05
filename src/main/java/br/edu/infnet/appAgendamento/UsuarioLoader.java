package br.edu.infnet.appAgendamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appAgendamento.model.domain.Usuario;
import br.edu.infnet.appAgendamento.model.service.UsuarioService;

@Order(3)
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) {
		try (BufferedReader leitura = new BufferedReader(new FileReader("files/Usuario.txt"))) {
			String linha = leitura.readLine();
			String[] campos;

			while (linha != null) {
				campos = linha.split(";");

				Usuario usuario = new Usuario();
				usuario.setNome(campos[0]);
				usuario.setEmail(campos[1]);
				usuario.setSenha(campos[2]);

				usuarioService.incluir(usuario);


				linha = leitura.readLine();
			}

			for (Usuario usuario : UsuarioService.obterLista()) {
				System.out.println("USUARIO: " + usuario);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
