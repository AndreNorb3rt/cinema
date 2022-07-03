package com.company.cinema.screen.seat;

import io.jmix.ui.screen.*;
import com.company.cinema.entity.Seat;

@UiController("Seat.browse")
@UiDescriptor("seat-browse.xml")
@LookupComponent("seatsTable")
public class SeatBrowse extends StandardLookup<Seat> {
}