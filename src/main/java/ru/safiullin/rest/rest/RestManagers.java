package ru.safiullin.rest.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.safiullin.rest.service.ManagerService;

@RestController
public class RestManagers {
    @Autowired
    private ManagerService managerService;

    

}
