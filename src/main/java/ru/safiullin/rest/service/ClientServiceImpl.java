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
        log.info("IN ClientServiceImpl getAll");
        return clientRepository.findAll();
    }

    @Override
    public Clients getById(Long id) {
        log.info("IN ClientServiceImpl getById {}", id);
        return clientRepository.getById(id);
    }

    @Override
    public void save(Clients clients) {
        log.info("IN ClientServiceImpl save {}", clients);
        clientRepository.save(clients);

    }

//    @Override
//    public void delete(Long id) {
//        log.info("IN ClientServiceImpl delete {}", id);
//        clientRepository.delete(id);
//    }
}
