package br.edu.infnet.appAgendamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appAgendamento.model.domain.Profissional;
import br.edu.infnet.appAgendamento.model.service.ProfissionalService;



@Order(2)
@Component
public class ProfissionalLoader implements ApplicationRunner {

	@Autowired
	private ProfissionalService profissionalService;

	@Override
	public void run(ApplicationArguments args) {
		try (BufferedReader leitura = new BufferedReader(new FileReader("files/Profissional.txt"))) {
			String linha = leitura.readLine();

			while (linha != null) {
				String[] campos = linha.split(";");
				Profissional profissional = new Profissional();
				profissional.setNome(campos[0].trim());
				profissional.setEmail(campos[1].trim());
				profissional.setSenha(campos[2].trim());
				profissional.setEspecialidade(campos[3].trim());

				profissionalService.incluir(profissional);
				linha = leitura.readLine();
			}

			profissionalService.obterLista().forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

