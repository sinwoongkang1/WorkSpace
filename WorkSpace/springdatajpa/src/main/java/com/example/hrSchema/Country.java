package com.example.hrSchema;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COUNTRIES")
@Getter
@Setter
@NoArgsConstructor
public class Country {

    @Id
    @Column(name = "country_id")
    private String id;

    @Column(name = "country_name")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region regions;
}
