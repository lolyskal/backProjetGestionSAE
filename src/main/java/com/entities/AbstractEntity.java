package com.entities;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

@Id
@Column(name = "id")
    private Long id;
	@CreatedDate
    @Column(name = "creationDate", nullable = false , updatable = false)
    private Instant creationDate;

    @LastModifiedDate
    @Column(name = "LastModifiedDate")
    private Instant LastModifiedDate;

}
