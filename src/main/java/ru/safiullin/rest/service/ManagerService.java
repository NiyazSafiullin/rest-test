package ru.safiullin.rest.service;

import ru.safiullin.rest.model.Managers;

import java.util.List;

public interface ManagerService {
    List<Managers> getAll();
    Managers getById(Long id);
    void save(Managers managers);
    void delete(Long id);
    List<Managers> findByDeputy();

  }
