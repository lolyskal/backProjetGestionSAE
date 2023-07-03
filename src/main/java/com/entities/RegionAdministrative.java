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
@Table(name = "regionAdministrative")
public class RegionAdministrative extends AbstractEntity {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "capital")
    private String capital;

    @Column(name = "chef_lieu_region")
    private String chefLieuRegion;

    @OneToMany(mappedBy = "regionAdministrative")
    private List<Prefecture> prefecture;


}
