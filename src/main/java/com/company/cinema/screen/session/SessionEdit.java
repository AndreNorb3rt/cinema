package com.company.cinema.screen.session;

import com.company.cinema.entity.Seat;
import com.company.cinema.entity.Ticket;
import io.jmix.core.EntityStates;
import io.jmix.ui.Notifications;
import io.jmix.core.DataManager;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import com.company.cinema.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@UiController("Session_.edit")
@UiDescriptor("session-edit.xml")
@EditedEntityContainer("sessionDc")
public class SessionEdit extends StandardEditor<Session> {
    @Autowired
    private DataManager dataManager;
    @Autowired
    private Notifications notifications;
    @Autowired
    private EntityStates entityStates;


    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (entityStates.isNew(getEditedEntity())){
            int sessionDuration = (getEditedEntity().getEndTime().getHour()*60+getEditedEntity().getEndTime().getMinute()
                    - getEditedEntity().getStartTime().getHour()*60+getEditedEntity().getStartTime().getMinute());
            if (sessionDuration < getEditedEntity().getFilm().getDuration()){
                notifications.create().withCaption("The duration of the session is shorter than the duration of the film").show();
                event.preventCommit();
            }
            else{
                event.resume();
                createTickets(getEditedEntity());
            }
        }
    }

    @Subscribe
    public void onAfterCommitChanges(AfterCommitChangesEvent event) {

    }

    private void createTickets(Session x) {
        List<Seat> seatInCinemaHall = dataManager.load(Seat.class)
                .query("select c from Seat c where c.cinemaHall=:hall")
                .parameter("hall", x.getCinemaHall())
                .list();
        for (int i = 0; i < seatInCinemaHall.size(); i++) {
            Ticket newTicket = dataManager.create(Ticket.class);
            newTicket.setSession(x);
            newTicket.setSeat(seatInCinemaHall.get(i));
            newTicket.setCost(seatInCinemaHall.get(i).getDefaultCost());
            dataManager.save(newTicket);
        }
    }

    private boolean checkSessionBeforeDelete(Session x) {//доделать пункт 5
        List<Ticket> tickets = dataManager.load(Ticket.class)
                .query("select c from Ticket c") //where c.cinemaHall = x.cinemaHall")
                .list();
        for (int i = 0; i < tickets.size(); i++) {
            if (x.getCinemaHall() == tickets.get(i).getSession().getCinemaHall())
                return true;
        }
        return false;
    }
}