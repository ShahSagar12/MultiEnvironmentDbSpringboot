package com.sagar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

import com.sagar.dao.PersonRepository;
import com.sagar.entity.Person;

@SpringBootApplication
public class MultipleEnvironmentSpringProjectApplication {
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(MultipleEnvironmentSpringProjectApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void intializeUserData() {
		Person person=new Person();
		String[] activeProfiles = environment.getActiveProfiles();
		if(activeProfiles[0].equalsIgnoreCase("DEV")){
			person.setName("Sagar Shah");
			person.setAge(20);
			person.setEmail("sagar@unlimit.com");
			person.setSource("Development");
			
		}else {
			person.setName("Sagar fShah");
			person.setAge(20);
			person.setEmail("sagar@unlimit.com");
			person.setSource("Production");
		}
		if(personRepository.findAll().isEmpty()) {
			personRepository.save(person);
		}
		

	}

}
