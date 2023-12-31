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
@Table(name = "sanction")
public class Sanction extends AbstractEntity {

    @Column(name = "code_sanction")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    @OneToMany(mappedBy = "sanction")
    private List<SanctionObtenu> sanctionObtenu;

}
