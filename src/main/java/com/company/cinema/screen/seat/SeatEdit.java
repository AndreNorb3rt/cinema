package com.company.cinema.screen.seat;

import io.jmix.ui.screen.*;
import com.company.cinema.entity.Seat;

@UiController("Seat.edit")
@UiDescriptor("seat-edit.xml")
@EditedEntityContainer("seatDc")
public class SeatEdit extends StandardEditor<Seat> {
}