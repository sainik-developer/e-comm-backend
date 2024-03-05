package org.example.repository;

import org.example.entity.ProductDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductDO, UUID> {


    @Query("SELECT p FROM products p WHERE p.quantity > 1")
    List<ProductDO> findAvailableProduct();

    Optional<ProductDO> findById(UUID id);



}
