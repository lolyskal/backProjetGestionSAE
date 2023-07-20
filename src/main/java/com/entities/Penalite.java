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
@Table(name = "penalite")
public class Penalite extends AbstractEntity {

    @Column(name = "typePenalite ")
    private String typePenalite;

    @Column(name = "duree")
    private Integer duree;

    @Column(name = "montant")
    private Double montant;

    @OneToMany(mappedBy = "penalite")
    private List<PenaliteObtenu> penalite_Obtenu;
}
