package br.edu.infnet.appAgendamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appAgendamento.model.domain.Cliente;
import br.edu.infnet.appAgendamento.model.service.ClienteService;

@Order(1)
@Component
public class ClienteLoader implements ApplicationRunner {

	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try (BufferedReader reader = new BufferedReader(new FileReader("files/Cliente.txt"))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(linha, ";");
				Cliente cliente = new Cliente();

				cliente.setNome(st.nextToken());
				cliente.setEmail(st.nextToken());
				if (st.hasMoreTokens()) {
					cliente.setSenha(st.nextToken());
				}
				if (st.hasMoreTokens()) {
					cliente.setNumeroCelular(st.nextToken());
				}

				clienteService.incluir(cliente);
			}

			clienteService.obterLista().forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


