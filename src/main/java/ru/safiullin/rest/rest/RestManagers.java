package ru.safiullin.rest.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.safiullin.rest.dto.ClientDto;
import ru.safiullin.rest.dto.ManagerDto;
import ru.safiullin.rest.mappers.MapperUtil;
import ru.safiullin.rest.model.Clients;
import ru.safiullin.rest.model.Managers;
import ru.safiullin.rest.service.ManagerService;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/managers/")
public class RestManagers {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Managers>> getAllManagers() {
        List<Managers> managers = this.managerService.getAll();

        if (managers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ManagerDto> findAll() {
        List<Managers> managers = managerService.getAll();
        return MapperUtil.convertList(managers, this::convertToManagerDto);
    }

    private ManagerDto convertToManagerDto(Managers managers) {
        ManagerDto managerDto = modelMapper.mapModels(managers, ManagerDto.class);
        managerDto.setFirstname(convertToClientDto(managers.getFirstname()));
        return managerDto;
    }
    private ClientDto convertToClientDto(Clients clients) {
        return modelMapper.mapModels(clients, ClientDto.class);
    }

}
