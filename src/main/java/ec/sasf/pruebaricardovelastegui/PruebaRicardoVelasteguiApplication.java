package ec.sasf.pruebaricardovelastegui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PruebaRicardoVelasteguiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaRicardoVelasteguiApplication.class, args);
	}

}
