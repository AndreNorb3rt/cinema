package com.company.cinema.listener;

import com.company.cinema.entity.CinemaHall;
import com.company.cinema.entity.Seat;
import com.company.cinema.entity.Session;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class SessionEventListener {

    @Autowired
    private DataManager dataManager;

    @EventListener
    public void onSessionSaving(EntitySavingEvent<Session> event) {
        if (event.isNewEntity()){
            createTickets(event.getEntity().getCinemaHall());
        }
    }
    private void createTickets(CinemaHall searchCinemaHall){
        ArrayList<Seat> seatInCinemaHall = dataManager.loadValues("select CinemaHall "+
                        "from Seat "+
                        "where Seat.cinemaHall = searchCinemaHall "
                        )


    }
}