package com.company.cinema.screen.ticket;

import com.company.cinema.entity.Session;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.cinema.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("ShowTickets.browse")
@UiDescriptor("showTickets-browse.xml")
@LookupComponent("ticketsTable")
public class ShowTicketsBrowse extends StandardLookup<Ticket> {

    @Autowired
    private CollectionLoader<Ticket> ticketsDl;

    public void setSelectedSession(Session session) {
        ticketsDl.setParameter("session", session);
    }
}
