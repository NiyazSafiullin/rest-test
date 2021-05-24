package ru.safiullin.rest.service;

import ru.safiullin.rest.model.Clients;

import java.util.List;

public interface ClientService {
    List<Clients> getAll();
    Clients getById(Long id);
    void save(Clients clients);
    void delete(Long id);

}
