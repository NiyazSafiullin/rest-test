package ru.safiullin.rest.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.safiullin.rest.model.Clients;
import ru.safiullin.rest.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients/")
public class RestClients {
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Clients>> getCustomers() {
        List<Clients> clients = clientService.getAll();
        if (clients.isEmpty()) {
            return new ResponseEntity<List<Clients>>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Clients>>(clients, HttpStatus.OK);
    }

}
