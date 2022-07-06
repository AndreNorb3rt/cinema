package com.company.cinema.screen.ticket;

import io.jmix.ui.screen.*;
import com.company.cinema.entity.Ticket;

@UiController("Tickets.browse")
@UiDescriptor("tickets-browse.xml")
@LookupComponent("ticketsTable")
public class TicketsBrowse extends StandardLookup<Ticket> {
}