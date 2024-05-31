package com.example.hrSchema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "REGIONS")
@Getter
@Setter
@NoArgsConstructor
public class Region {
    @Id
    @Column(name = "region_id")
    private Long id;
    @Column(name = "region_name")
    private String regionName;

}
