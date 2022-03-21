package com.devsuperior.uri2990;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.repositories.EmpregadoRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<EmpregadoDeptProjection> list = repository.search01();
		List<EmpregadoDeptDTO> result01 = list.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());

		System.out.println("  *** SQL RAIZ LEFT JOIN ***");
		for(EmpregadoDeptDTO e : result01){
			System.out.println(e);
		}

		System.out.println("\n");

		List<EmpregadoDeptDTO> list2 = repository.search02();

		System.out.println("  *** SQL JPQL ***");
		for(EmpregadoDeptDTO e : list2){
			System.out.println(e);
		}

		System.out.println("\n");

		List<EmpregadoDeptProjection> list3 = repository.search03();
		List<EmpregadoDeptDTO> result03 = list.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());

		System.out.println("  *** SQL RAIZ NOT IN ***");
		for(EmpregadoDeptDTO e : result03){
			System.out.println(e);
		}

		System.out.println("\n");
		
	}
}
