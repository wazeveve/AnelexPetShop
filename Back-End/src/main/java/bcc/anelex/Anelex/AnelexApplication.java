package bcc.anelex.Anelex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AnelexApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnelexApplication.class, args);
	}

}
