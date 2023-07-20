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
@Table(name = "prefecture")
public class Prefecture extends AbstractEntity {


    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "chefLieu")
    private String chefLieu;

    @ManyToOne
    @JoinColumn(name = "idRegionAdministrative")
    private RegionAdministrative regionAdministrative;

    @OneToMany(mappedBy = "prefecture")
    private List<Commune> commune;


}
