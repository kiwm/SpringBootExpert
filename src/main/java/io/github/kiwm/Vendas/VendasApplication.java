package io.github.kiwm.Vendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;

@SpringBootApplication
@RestController
//@ComponentScan(basePackages = {"class1url", "class2url"}) para escaniar pakotes esternos de forma expecificada
public class VendasApplication {

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
