package com.company.cinema.listener;

import com.company.cinema.entity.CinemaHall;
import com.company.cinema.entity.Seat;
import com.company.cinema.entity.Session;
import com.company.cinema.entity.Ticket;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.event.EntitySavingEvent;
import io.jmix.ui.Notifications;
import io.jmix.ui.RemoveOperation;
import io.jmix.ui.exception.DeletePolicyExceptionHandler;
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

    @Autowired
    private DeletePolicyExceptionHandler deletePolicyExceptionHandler;
//@Autowired
    //private Notifications notifications;

    @EventListener
    public void onSessionBeforeSaving(EntityChangedEvent<Session> event) {
        //Session session;
        if (event.getType() == EntityChangedEvent.Type.DELETED){
            if(checkSessionBeforeDelete(event.getEntityId())){
                deletePolicyExceptionHandler.getOrder();
            }
        }


    }
    private boolean checkSessionBeforeDelete(Id<Session> x) {
        Session s = dataManager.load(Session.class)
                .query("select c from Session_ c where c.id =: x")
                .parameter("x", x)
                .one();
        List<Ticket> tickets = dataManager.load(Ticket.class)
                .query("select c from Ticket c where c.session=:x and c.client is not null")
                .parameter("s", s)
                .list();
        if (tickets.size()>0)
            return true;
        else
            return false;
    }


}