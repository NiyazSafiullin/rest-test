package ru.safiullin.rest.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "managers")
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "deputy")
    private String deputy;

    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    private Clients clients;

}
