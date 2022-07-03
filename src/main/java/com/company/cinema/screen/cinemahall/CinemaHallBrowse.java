package com.company.cinema.screen.cinemahall;

import io.jmix.ui.screen.*;
import com.company.cinema.entity.CinemaHall;

@UiController("CinemaHall.browse")
@UiDescriptor("cinema-hall-browse.xml")
@LookupComponent("cinemaHallsTable")
public class CinemaHallBrowse extends StandardLookup<CinemaHall> {
}