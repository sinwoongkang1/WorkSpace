package com.example.hrSchema;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "JOBS")
@Getter
@Setter
@NoArgsConstructor
public class Job {
    @Id
    @JoinColumn(name = "job_id")
    @Column(name = "job_id")
    private String jobId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "min_salary")
    private Double minSalary;

    @Column(name = "max_salary")
    private Double maxSalary;

    @OneToMany(mappedBy = "job")
    private Set<JobHistory> jobHistories;

    @OneToMany(mappedBy = "job")
    private Set<Employee> employees;
}
