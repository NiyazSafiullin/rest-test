package ru.safiullin.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private String name;
    private String legaladdress;
    private String managerid;
    private String role="ROLE_USER";
    private boolean locked=false;
    @JsonProperty("clients")
    ManagerDto managerDto;
}
