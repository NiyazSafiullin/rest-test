package ru.safiullin.rest.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.safiullin.rest.model.Clients;
import ru.safiullin.rest.repository.ClientRepository;

import java.util.List;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Clients> getAll() {
        return clientRepository.findAll();
    }
}
