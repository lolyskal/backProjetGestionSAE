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
@Table(name = "ordreEnseignement")
public class OrdreEnseignement extends AbstractEntity {


    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "numero")
    private Long numero;


    @OneToMany(mappedBy = "ordreEnseignement")
    private List<Etablissement> etablissement;


}
