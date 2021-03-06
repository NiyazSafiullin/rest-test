package ru.safiullin.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Clients {

    @Column(name = "name")
    private String name;

    @Column(name = "legaladdress")
    private String legaladdress;

    @Column(name = "managerid")
    private int managerid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role="ROLE_USER";

    //private boolean locked=false;


}
