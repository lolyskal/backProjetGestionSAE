package com.entities;

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
@Table(name = "penaliteObtenu")
public class PenaliteObtenu extends AbstractEntity {


	@Id
    @Column(name = "date")
    private String date;

    @Column(name = "motif")
    private String motif;

    @ManyToOne
    @JoinColumn(name = "IdPenalite")
    private Penalite penalite;

    @ManyToOne
    @JoinColumn(name = "IdEtablissement")
    private Etablissement etablissement;

}
