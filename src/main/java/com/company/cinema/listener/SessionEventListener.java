package com.company.cinema.listener;

import com.company.cinema.entity.Seat;
import com.company.cinema.entity.Ticket;
import com.company.cinema.entity.Session;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.core.event.EntityChangedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

@Component
public class SessionEventListener {

    @Autowired
    private DataManager dataManager;

    @EventListener
    public void onSessionBeforeSaving(EntityChangedEvent<Session> event) {

        if (event.getType() == EntityChangedEvent.Type.DELETED){
            if(checkSessionBeforeDelete(event.getEntityId())){
                throw new RuntimeException("На сеанс уже продан билет");
            }
        }

    }
    private boolean checkSessionBeforeDelete(Id<Session> x) {

        List<Ticket> ticketsInSession = dataManager.load(Ticket.class)
                .query("select c from Ticket c where c.session.id=:X and c.client is not null ")
                .parameter("X", x)
                .list();
        if (ticketsInSession.size()>0)
            return true;
        else
            return false;
    }


}