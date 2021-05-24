package ru.safiullin.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.safiullin.rest.model.Managers;

public interface ManagerRepository extends JpaRepository<Managers, Long> {
}
