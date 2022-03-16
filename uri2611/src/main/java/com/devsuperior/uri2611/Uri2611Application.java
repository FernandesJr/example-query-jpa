package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<MovieMinProjection> list = movieRepository.search01("Action");
		List<MovieMinDTO> result01 = list.stream().map(x -> new MovieMinDTO(x)).collect(Collectors.toList());

		System.out.println("\n ***SQL RAIZ***");
		for(MovieMinDTO m: result01){
			System.out.println(m);
		}

		List<MovieMinDTO> result02 = movieRepository.search02("Action");

		System.out.println("\n ***SQL JPQL***");
		for(MovieMinDTO m: result02){
			System.out.println(m);
		}
	}
}
