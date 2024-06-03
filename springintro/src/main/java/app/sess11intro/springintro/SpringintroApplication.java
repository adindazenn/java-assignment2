package app.sess11intro.springintro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.sess11intro.springintro.entity.User;
import app.sess11intro.springintro.entity.Address;
import app.sess11intro.springintro.repository.UserRepository;
import app.sess11intro.springintro.repository.AddressRepository;


@SpringBootApplication
public class SpringintroApplication
	// implementasi ke database melalui JPA
	implements CommandLineRunner
{
	private final Logger logger = LoggerFactory.getLogger(SpringintroApplication.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringintroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//create user & address
		User user = new User();
		user.setNama("Adinda Zen");
		user.setEmail("AdindaZen@gmail.com");
		user.setPassword("12345");

		Address address = new Address();
		address.setCity("Jepara");
		address.setCountry("Indonesia");
		address.setState("Jawa Tengah");
		address.setStreet("Jl Pemuda");
		address.setZipCode("53412");
		address.setUser(user);

		userRepository.save(user);
		logger.info("Berhasil menyimpan user!");

		addressRepository.save(address);
		logger.info("Berhasil menyimpan address!");
	}
}
