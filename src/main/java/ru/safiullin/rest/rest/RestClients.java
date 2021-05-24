package ru.safiullin.rest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.safiullin.rest.model.Clients;
import ru.safiullin.rest.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients/")
public class RestClients {
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clients> getClients(@PathVariable("id") Long clientId) {
         if (clientId == null) {
            return new ResponseEntity<Clients>(HttpStatus.BAD_REQUEST);
        }
        Clients clients = this.clientService.getById(clientId);
        if (clients == null) {
            return new ResponseEntity<Clients>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Clients>(clients,HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clients> saveCustomer(@RequestBody @Validated Clients clients) {
        HttpHeaders headers = new HttpHeaders();

        if (clients == null) {
            return new ResponseEntity<Clients>(HttpStatus.BAD_REQUEST);
        }

        this.clientService.save(clients);
        return new ResponseEntity<Clients>(clients, headers, HttpStatus.CREATED);
    }
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Clients>> getAllCustomers() {
        List<Clients> clients = this.clientService.getAll();

        if (clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clients> updateCustomer(@RequestBody @Validated Clients clients, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (clients == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.clientService.save(clients);

        return new ResponseEntity<>(clients, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Clients> deleteCustomer(@PathVariable("id") Long id) {
        Clients clients = this.clientService.getById(id);

        if (clients == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.clientService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
