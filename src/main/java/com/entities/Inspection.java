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
@Table(name = "inspection")
public class Inspection extends AbstractEntity {

    @Id
    protected Long id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "libelle")
    private String libelle;

    @ManyToOne
    @JoinColumn(name = "idRegionEducative")
    private RegionEducative regionEducative;

    @OneToMany(mappedBy = "inspection")
    private List<Etablissement> etablissement;

}
