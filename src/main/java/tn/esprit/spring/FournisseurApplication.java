package tn.esprit.spring;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.repositories.FournisseurRepository;

@SpringBootApplication
@EnableEurekaClient
public class FournisseurApplication {

	public static void main(String[] args) {
		SpringApplication.run(FournisseurApplication.class, args);
	}
	@Bean
	 ApplicationRunner init(FournisseurRepository repository){
		return args ->{
			Stream.of("aziz","maamar","mohamedaziz.maamar@esprit.tn").forEach(nom ->{
				repository.save(new Fournisseur(nom));
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
