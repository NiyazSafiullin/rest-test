package ru.safiullin.rest.service;

import org.springframework.stereotype.Service;
import ru.safiullin.rest.model.Managers;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Override
    public List<Managers> getAll() {
        return null;
    }

    @Override
    public Managers getById(Long id) {
        return null;
    }

    @Override
    public void save(Managers managers) {

    }
}
