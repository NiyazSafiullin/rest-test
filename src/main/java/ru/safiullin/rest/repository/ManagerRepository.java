package ru.safiullin.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.safiullin.rest.model.Managers;

import java.util.List;


public interface ManagerRepository extends JpaRepository<Managers, Long> {
    @Query("SELECT t FROM Managers t WHERE t.deputy = ?1 AND t.deputy = ?2")
    List<Managers> findByDeputy();
}
