package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT products.name FROM products " +
            "INNER JOIN providers ON " +
            "providers.id = products.id_providers " +
            "WHERE products.amount BETWEEN :min AND :max " +
            "AND providers.name LIKE CONCAT(:beginName, '%')")
    public List<ProductMinProjection> search01(Integer min, Integer max, String beginName); //começo do nome

    @Query("SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(obj.name) FROM Product obj " +
            "WHERE obj.amount BETWEEN :min AND :max " +
            "AND obj.provider.name LIKE CONCAT(:beginName, '%')")
    public List<ProductMinDTO> search02(Integer min, Integer max, String beginName); //começo do nome
}
