package es.ozona.moira.project.process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MoiraProjectProcessPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoiraProjectProcessPersonApplication.class, args);
	}

}
