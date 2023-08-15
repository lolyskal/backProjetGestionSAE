package com.entities;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "fraisCycle")
public class FraisCycle extends AbstractEntity {


    @Column(name = "code")
    private int code;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "prix_Cycle_Enseignemant")
    private String prix_Cycle_Enseignemant;

    @OneToMany(mappedBy = "fraisCyle")
    private List<AgrementObtenu> agrementObtenu;
}
