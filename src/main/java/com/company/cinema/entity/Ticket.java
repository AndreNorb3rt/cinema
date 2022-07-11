package com.company.cinema.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Table(name = "TICKET", indexes = {
        @Index(name = "IDX_TICKET_SEAT_ID", columnList = "SEAT_ID"),
        @Index(name = "IDX_TICKET_CLIENT_ID", columnList = "CLIENT_ID"),
        @Index(name = "IDX_TICKET_SESSION_ID", columnList = "SESSION_ID")
})
@Entity
public class Ticket {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "SEAT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Seat seat;

    @Column(name = "COST", precision = 19, scale = 2)
    private BigDecimal cost;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "CLIENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "SESSION_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"client", "cost", "seat"})
    public String getInstanceName() {
        return String.format("%s, %s, %s, %s", client, cost, seat, session);
    }
}