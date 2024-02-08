package com.ms.userapi;

import com.ms.userapi.domain.User;
import com.ms.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(List.of(
				new User(null, "Ximba1", "ximba1@gmail.com", "1234", 50.00),
				new User(null, "Ximba2", "ximba2@gmail.com", "12345", 40.00),
				new User(null, "Ximba3", "ximba3@gmail.com", "123456", 10.00)
		));
	}
}
