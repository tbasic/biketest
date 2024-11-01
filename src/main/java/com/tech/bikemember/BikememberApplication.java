package com.tech.bikemember;

import com.tech.bikemember.model.BikeMember;
import com.tech.bikemember.repository.BikeMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BikememberApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BikememberApplication.class, args);
	}

	@Autowired
	private BikeMemberRepository bikeMemberRepository;

	@Override
	public void run(String... args) throws Exception {
//		BikeMember bikeMember=new BikeMember();
//		bikeMember.setFirstName("Tom1");
//		bikeMember.setLastName("John1");
//		bikeMember.setEmailId("tom1@mail.com");
//		bikeMemberRepository.save(bikeMember);
	}
}
