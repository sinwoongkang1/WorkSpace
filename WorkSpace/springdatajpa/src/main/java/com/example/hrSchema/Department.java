package com.example.hrSchema;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "DEPARTMENTS")
@Getter
@Setter
@NoArgsConstructor
public class Department {
    @Id
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee managerId;

//    @ManyToOne
//    @JoinColumn(name = "location_id")
//    private Location location
//
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
}
