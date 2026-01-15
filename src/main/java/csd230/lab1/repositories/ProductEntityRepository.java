package csd230.lab1.repositories;

import csd230.lab1.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findById(long id);

}