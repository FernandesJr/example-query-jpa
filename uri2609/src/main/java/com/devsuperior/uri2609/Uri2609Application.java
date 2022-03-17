package com.devsuperior.uri2609;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<CategorySumProjection> list = repository.search01();
		List<CategorySumDTO> result01 = list.stream().map(x -> new CategorySumDTO(x)).collect(Collectors.toList());

		System.out.println("*** SQL RAIZ ***");
		for(CategorySumDTO d : result01){
			System.out.println(d);
		}
		System.out.println("\n");

		List<CategorySumDTO> result02 = repository.search02();

		System.out.println("*** SQL JPQL ***");
		for(CategorySumDTO d : result02){
			System.out.println(d);
		}
	}
}
