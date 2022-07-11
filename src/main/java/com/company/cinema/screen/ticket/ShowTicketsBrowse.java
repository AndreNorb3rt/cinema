package com.company.cinema.screen.ticket;

import com.company.cinema.entity.Session;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.DataComponents;
import io.jmix.ui.screen.*;
import com.company.cinema.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;


@UiController("ShowTickets.browse")
@UiDescriptor("showTickets-browse.xml")
@LookupComponent("ticketsTable")
public class ShowTicketsBrowse extends StandardLookup<Ticket> {

    //@Autowired
    private Session sessionX;
    @Autowired
    private DataComponents dataComponents;

    private CollectionLoader<Ticket> ticketsDl;

   /* private void createShowTicketsLoader(CollectionContainer<Ticket> container) {
        Session s = session;
        ticketsDl = dataComponents.createCollectionLoader();
        ticketsDl.setQuery("select e from Ticket e where e.seat.placeNumber = 2");
        //ticketsDl.setParameter("x", s);
        ticketsDl.setContainer(container);
        ticketsDl.setDataContext(getScreenData().getDataContext());
    }*/

    public void setSelectedSession(Session x) {
        sessionX = x;
    }


}