package ru.safiullin.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.safiullin.rest.model.Clients;

public interface ClientRepository extends JpaRepository<Clients, Long> {
}
