package com.company.cinema.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "SESSION_", indexes = {
        @Index(name = "IDX_SESSION_CINEMA_HALL_ID", columnList = "CINEMA_HALL_ID"),
        @Index(name = "IDX_SESSION_FILM_ID", columnList = "FILM_ID")
})
@Entity(name = "Session_")
public class Session {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Composition
    @OneToMany(mappedBy = "session")
    private List<Ticket> tickets;

    @JoinColumn(name = "CINEMA_HALL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CinemaHall cinemaHall;

    @JoinColumn(name = "FILM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Film film;

    @Column(name = "START_TIME", nullable = false)
    @NotNull
    private LocalDateTime startTime;

    @Column(name = "END_TIME", nullable = false)
    @NotNull
    private LocalDateTime endTime;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"cinemaHall", "film", "startTime", "endTime"})
    public String getInstanceName() {
        return String.format("%s, %s min, %s %s %s:%s - %s:%s", cinemaHall.getInstanceName(), film.getInstanceName(), startTime.getDayOfMonth(), startTime.getMonth(), startTime.getHour() , startTime.getMinute(), endTime.getHour() , endTime.getMinute());
    }




}