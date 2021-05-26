package ru.safiullin.rest.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.safiullin.rest.model.Clients;
import ru.safiullin.rest.model.Managers;
import ru.safiullin.rest.service.ManagerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/managers/")
public class RestManagers {
    @Autowired
    private ManagerService managerService;


    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Managers>> getAllManagers() {
        List<Managers> managers = this.managerService.getAll();

        if (managers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Managers>> getAllManagersDeputy() {
        List<Managers> managers = this.managerService.getManagersListDeputy();

        if (managers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Managers> getManagers(@PathVariable("id") Long managerId) {
        if (managerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

       Managers managers = this.managerService.getById(managerId);
        if (managers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(managers,HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Managers> saveManager(@RequestBody @Validated Managers managers) {
        HttpHeaders headers = new HttpHeaders();

        if (managers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.managerService.save(managers);
        return new ResponseEntity<>(managers, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Managers> deleteManager(@PathVariable("id") Long id) {
        Managers managers = this.managerService.getById(id);

        if (managers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.managerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
