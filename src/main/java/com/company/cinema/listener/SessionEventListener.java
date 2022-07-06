package com.company.cinema.listener;

import com.company.cinema.entity.CinemaHall;
import com.company.cinema.entity.Seat;
import com.company.cinema.entity.Session;
import com.company.cinema.entity.Ticket;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.event.EntityLoadingEvent;
import io.jmix.core.event.EntitySavingEvent;
import io.jmix.ui.Dialogs;
import io.jmix.ui.Notifications;
import io.jmix.ui.screen.Subscribe;
import org.codehaus.groovy.control.messages.Message;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SessionEventListener {

    @Autowired
    private DataManager dataManager;
    @Autowired
    private Dialogs dialogs;
    @Autowired
    private ObjectProvider<Notifications> notificationsProvider;

    @EventListener
    public void onSessionChangedBeforeCommit(EntityChangedEvent<Session> event) {
        if (event.getType() == EntityChangedEvent.Type.DELETED){ //&& checkSessionBeforeDelete()

        }
    }



    private boolean checkSessionBeforeDelete(Session x) {//доделать пункт 5
        List<Ticket> tickets = dataManager.load(Ticket.class)
                .query("select c from Ticket c, Session_ x where c.session = x")
                .list();
        if (tickets.size() > 0)
            return true;
        return false;
    }

}