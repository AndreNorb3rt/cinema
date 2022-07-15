package com.company.cinema.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Table(name = "SEAT", indexes = {
        @Index(name = "IDX_SEAT_CINEMA_HALL_ID", columnList = "CINEMA_HALL_ID")
})
@Entity
public class Seat {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "CINEMA_HALL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CinemaHall cinemaHall;

    @Column(name = "ROW_NUMBER_", nullable = false)
    @NotNull
    private Integer rowNumber;

    @Column(name = "PLACE_NUMBER")
    private Integer placeNumber;

    @Column(name = "DEFAULT_COST", nullable = false, precision = 19, scale = 2)
    @NotNull
    private BigDecimal defaultCost;

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public BigDecimal getDefaultCost() {
        return defaultCost;
    }

    public void setDefaultCost(BigDecimal default_cost) {
        this.defaultCost = default_cost;
    }

    public Integer getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(Integer place_number) {
        this.placeNumber = place_number;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer row_number) {
        this.rowNumber = row_number;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"rowNumber", "placeNumber"})
    public String getInstanceName() {
        return String.format("%s, %s",  rowNumber, placeNumber);
    }
}