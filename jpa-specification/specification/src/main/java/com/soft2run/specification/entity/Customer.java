package com.soft2run.specification.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@ToString
@Entity
@Table(name = "customer")
public class Customer {

    public enum ENTITY {
        LEGAL,
        PHYSICAL
    }

    @Id
    @GenericGenerator(name="gen", strategy="increment")
    @GeneratedValue(generator="gen")
    private Long id;

    @Column(name = "first_name", columnDefinition = "varchar(50)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(50)")
    private String lastName;

    @Column(name = "full_name", nullable = false, columnDefinition = "varchar(100)")
    private String fullName;

    @Column(name = "title", columnDefinition = "varchar(10)")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "entity", nullable = false, columnDefinition = "varchar(10)")
    private ENTITY entity;

    @Column(name = "creation_time", nullable = false)
    private LocalDateTime creationTime;

    @Column(name = "modification_time")
    private LocalDateTime modificationTime;

    @Transient
    private boolean blocked;

    @Transient
    private LocalDateTime blockedFrom;

    @Transient
    private LocalDateTime blockedTo;
}