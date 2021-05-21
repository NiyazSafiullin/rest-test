package ru.safiullin.rest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "managers")
public class Managers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

}