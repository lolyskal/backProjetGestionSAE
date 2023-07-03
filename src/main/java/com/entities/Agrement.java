package com.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "agrement")
public class Agrement extends AbstractEntity {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "numeroAgrement")
    private Long numeroAgrement;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "duree")
    private int duree;
    @JsonIgnore
    @OneToMany(mappedBy = "agrement")
    private List<AgrementObtenu> agrementObtenu;


}
