package com.company.cinema.listener;

import com.company.cinema.entity.CinemaHall;
import com.company.cinema.entity.Seat;
import com.company.cinema.entity.Session;
import com.company.cinema.entity.Ticket;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SessionEventListener {

    @Autowired
    private DataManager dataManager;

    @EventListener
    public void onSessionSaving(EntitySavingEvent<Session> event) {
        if (event.isNewEntity()){
            createTickets(event.getEntity());
        }
    }
    private void createTickets(Session x){
        List<Seat> seatInCinemaHall = dataManager.load(Seat.class)
                .query("select c from Seat c ")
                .list();//.stream().filter(e -> e.<Seat>getCinemaHall() == x.getCinemaHall());
        Ticket newTicket = dataManager.create(Ticket.class);
        newTicket.setSession(x);
        newTicket.setSeat(seatInCinemaHall.get(0));
        newTicket.setCost(seatInCinemaHall.get(0).getDefaultCost());
        dataManager.save(newTicket);
    }
}