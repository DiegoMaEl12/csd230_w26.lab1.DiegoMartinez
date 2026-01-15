package csd230.lab1.repositories;

import csd230.lab1.entities.PublicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublicationEntityRepository extends JpaRepository<PublicationEntity, Long> {
    Optional<PublicationEntity> findById(long id);
    PublicationEntity findByTitle(String title);
    PublicationEntity findByCopiesGreaterThan(int copies);
}