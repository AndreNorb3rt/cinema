package com.company.cinema.screen.ticket;

import io.jmix.ui.screen.*;
import com.company.cinema.entity.Ticket;

@UiController("Ticket.browse")
@UiDescriptor("ticket-browse.xml")
@LookupComponent("ticketsTable")
public class TicketBrowse extends StandardLookup<Ticket> {
}