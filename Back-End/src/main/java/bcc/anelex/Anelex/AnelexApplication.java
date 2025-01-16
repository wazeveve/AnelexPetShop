package bcc.anelex.Anelex;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnelexApplication {

	// Find your Account Sid and Token at console.twilio.com
	public static final String ACCOUNT_SID = "AC5a7eeaa689aa1c9d717f0e28d3605da5";
	public static final String AUTH_TOKEN = "6aace9bc9faa03d85673cc364ec79455";

	public static void main(String[] args) {
		SpringApplication.run(AnelexApplication.class, args);
	}

	@Bean
	public CommandLineRunner sendTwilioMessage() {
		return args -> {
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			Message message = Message.creator(
					new com.twilio.type.PhoneNumber("+16204009307"),
					new com.twilio.type.PhoneNumber("+5535997513815"),
					"VOCE TEM CONSULTAAAA!!!!"
			).create();
			System.out.println("Message SID: " + message.getSid());
		};
	}

}
