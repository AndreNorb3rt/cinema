package com.company.cinema.screen.ticket;

import io.jmix.ui.screen.*;
import com.company.cinema.entity.Ticket;

@UiController("Ticket.edit")
@UiDescriptor("ticket-edit.xml")
@EditedEntityContainer("ticketDc")
public class TicketEdit extends StandardEditor<Ticket> {
}