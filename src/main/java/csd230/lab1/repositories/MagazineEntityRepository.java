package csd230.lab1.repositories;

import csd230.lab1.entities.MagazineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface MagazineEntityRepository extends JpaRepository<MagazineEntity, Long> {
    MagazineEntity findByOrderQty(int orderQty);
    MagazineEntity findByCurrentIssue(LocalDateTime currentIssue);
    Optional<MagazineEntity> findById(long id);
    MagazineEntity findByOrderQtyGreaterThan(int orderQty);
}