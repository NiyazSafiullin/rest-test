package ru.safiullin.rest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.safiullin.rest.model.Managers;
import ru.safiullin.rest.service.ManagerService;

import java.util.List;

@RestController
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

}
