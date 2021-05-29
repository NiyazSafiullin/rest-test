package ru.safiullin.rest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import ru.safiullin.rest.dto.ClientDto;
import ru.safiullin.rest.dto.ManagerDto;
import ru.safiullin.rest.mappers.MapperUtil;
import ru.safiullin.rest.model.Clients;
import ru.safiullin.rest.model.Managers;
import ru.safiullin.rest.service.ManagerService;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;

public class RestManagerDto {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/all")
    public List<ManagerDto> findAll() {
        List<Managers> managers = managerService.getAll();
        return MapperUtil.convertList(managers, this::convertToManagerDto);
    }

    private ManagerDto convertToManagerDto(Managers managers) {
//        ManagerDto managerDto = modelMapper.mapModels(managers, ManagerDto.class);
//        managerDto.setFirstname(convertToClientDto(managers.getFirstname()));
//        return managerDto;
        return null;
    }

    private ClientDto convertToClientDto(Clients clients) {

        //return modelMapper.mapModels(clients, ClientDto.class);
        return null;
    }
}
