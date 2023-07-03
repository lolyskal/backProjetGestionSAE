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
@Table(name = "commune")
public class Commune extends AbstractEntity {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    @ManyToOne
    @JoinColumn(name = "idPrefecture")
    private Prefecture prefecture;

    @OneToMany(mappedBy = "commune")
    private List<Canton> canton;

}
