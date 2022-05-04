package io.github.kiwm.Vendas;

import io.github.kiwm.Vendas.model.Client;
import io.github.kiwm.Vendas.model.Request;
import io.github.kiwm.Vendas.repository.ClientRepository;
import io.github.kiwm.Vendas.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
//@ComponentScan(basePackages = {"class1url", "class2url"}) para escaniar pakotes esternos de forma expecificada
public class VendasApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired ClientRepository clientRepository,
			@Autowired RequestRepository requestRepository
	){
		return args -> {
			Client fulano = new Client("Douglas");
			clientRepository.save(fulano);


			Request request = new Request();
			request.setClient(fulano);
			request.setDateRequest(LocalDate.now());
			request.setTotal(BigDecimal.valueOf(100));

			requestRepository.save(request);

			Client client = clientRepository.findClienteFetchPedidos(fulano.getId());
			System.out.println(client);
			System.out.println(client.getRequests());
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
