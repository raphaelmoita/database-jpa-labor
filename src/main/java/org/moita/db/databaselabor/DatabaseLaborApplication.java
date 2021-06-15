package org.moita.db.databaselabor;

import org.moita.db.databaselabor.repository.ContainerRepository;
import org.moita.db.databaselabor.repository.MetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DatabaseLaborApplication {

	private final ContainerRepository containerRepository;
	private final MetadataRepository metadataRepository;

	@Autowired
	public DatabaseLaborApplication(ContainerRepository containerRepository,
	                                MetadataRepository metadataRepository) {
		this.containerRepository = containerRepository;
		this.metadataRepository = metadataRepository;
	}

	@PostConstruct
	public void init() {
		System.out.println("***********************");
		containerRepository.findAll().forEach(System.out::println);
//		metadataRepository.findAll().forEach(System.out::println);
		System.out.println("***********************");
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseLaborApplication.class, args);
	}

}
