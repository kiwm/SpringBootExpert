package io.github.kiwm.Vendas;

import io.github.kiwm.Vendas.model.Client;
import io.github.kiwm.Vendas.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;
import java.util.List;

@SpringBootApplication
@RestController
//@ComponentScan(basePackages = {"class1url", "class2url"}) para escaniar pakotes esternos de forma expecificada
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClientsRepository clientsRepository) {
		return args -> {
			clientsRepository.save(new Client("Douglas"));
			clientsRepository.save(new Client("Rogerio"));

			List<Client> allClients = clientsRepository.findAll();
			allClients.forEach(System.out::println);

			System.out.println("Atualizando");
			allClients.forEach(c -> {
				c.setName(c.getName() + " updated");
				clientsRepository.save(c);
			});

			allClients = clientsRepository.findAll();
			allClients.forEach(System.out::println);

			System.out.println("Buscando clientes");
			clientsRepository.findByNameLike("Douglas updated").forEach(System.out::println);

			System.out.println("deletando clientes");
			clientsRepository.findAll().forEach(c -> {
				clientsRepository.delete(c);
			});

			allClients = clientsRepository.findAll();
			if(allClients.isEmpty()) {
				System.out.println("nenhum cliente encontrado.");
			} else {
				allClients.forEach(System.out::println);
			}

		};
	}

	@Value("${application.name}")
	private String applicationName;

	@Qualifier(value = "testConfig")
	@Autowired
	private String testConfig;

	@GetMapping("/")
	public String helloWord() {
		return applicationName + testConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
