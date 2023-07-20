package com.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "regionEducative")
public class RegionEducative extends AbstractEntity {


    @Column(name = "libelle")
    private String libelle;

    @Column(name = "zoneCouverture")
    private String zoneCouverture;

    @Column(name = "chefLieu")
    private String chefLieu;

    @OneToMany(mappedBy = "regionEducative")
    private List<Inspection> inspection;

}
