package com.company.cinema.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CLIENT")
@Entity
public class Client {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "FULL_NAME", nullable = false)
    @NotNull
    private String fullName;

    @Composition
    @OneToMany(mappedBy = "client")
    private List<Ticket> listOfTikets;

    public List<Ticket> getListOfTikets() {
        return listOfTikets;
    }

    public void setListOfTikets(List<Ticket> listOfTikets) {
        this.listOfTikets = listOfTikets;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"fullName"})
    public String getInstanceName() {
        return String.format("%s", fullName);
    }
}