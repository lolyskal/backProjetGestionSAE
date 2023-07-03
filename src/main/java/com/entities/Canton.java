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
@Table(name = "canton")
public class Canton extends AbstractEntity {


    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    @ManyToOne
    @JoinColumn(name = "idCommune")
    private Commune commune;

    @OneToMany(mappedBy = "Canton")
    private List<Etablissement> etablissement;
}
