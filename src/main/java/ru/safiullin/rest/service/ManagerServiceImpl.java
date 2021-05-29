package ru.safiullin.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.safiullin.rest.model.Managers;
import ru.safiullin.rest.repository.ManagerRepository;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository managerRepository;
    @Override
    public List<Managers> getAll() {
        return managerRepository.findAll();
    }

    @Override
    public Managers getById(Long id) {
        return managerRepository.getById(id);
    }

    @Override
    public void save(Managers managers) {
        managerRepository.save(managers);
    }

    @Override
    public void delete(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public List<Managers> getManagersListDeputy() {
        return managerRepository.findByDeputy();
    }


}
