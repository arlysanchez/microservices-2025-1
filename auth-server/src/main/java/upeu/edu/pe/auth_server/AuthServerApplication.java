package upeu.edu.pe.auth_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthServerApplication /*implements CommandLineRunner*/ {
	//method for generation un password hash
  /*
	@Autowired
	private BCryptPasswordEncoder encoder;
*/

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
	/*
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Password:"+encoder.encode("secret2025"));

	}
	*/

}
