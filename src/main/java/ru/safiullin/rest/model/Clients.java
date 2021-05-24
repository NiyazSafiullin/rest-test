package ru.safiullin.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "clients")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Clients {

    @Column(name = "name")
    private String name;

    @Column(name = "legaladdress")
    private String legaladdress;

    @Column(name = "managerid")
    private String managerid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
