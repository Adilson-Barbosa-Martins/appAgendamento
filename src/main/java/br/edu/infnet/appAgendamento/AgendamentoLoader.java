package br.edu.infnet.appAgendamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appAgendamento.model.domain.Agendamento;
import br.edu.infnet.appAgendamento.model.domain.Cliente;
import br.edu.infnet.appAgendamento.model.domain.Profissional;
import br.edu.infnet.appAgendamento.model.service.AgendamentoService;
import br.edu.infnet.appAgendamento.model.service.ClienteService;
import br.edu.infnet.appAgendamento.model.service.ProfissionalService;

@Component
@Order(3)
public class AgendamentoLoader implements ApplicationRunner {

	@Autowired
	private AgendamentoService agendamentoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProfissionalService profissionalService;

	private int nextId = 1;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try (BufferedReader reader = new BufferedReader(new FileReader("files/Agendamento.txt"))) {
			String linha;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			while ((linha = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(linha, ";");
				Agendamento agendamento = new Agendamento();

				agendamento.setId(nextId++);
				agendamento.setData(LocalDateTime.parse(st.nextToken(), formatter));

				st.nextToken();

				String nomeCliente = st.nextToken();
				Cliente cliente = clienteService.buscarPorNome(nomeCliente);
				agendamento.setCliente(cliente);

				String nomeProfissional = st.nextToken();
				Profissional profissional = profissionalService.buscarPorNome(nomeProfissional);
				agendamento.setProfissional(profissional);

				agendamentoService.incluir(agendamento);
			}

			agendamentoService.obterLista().forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}




