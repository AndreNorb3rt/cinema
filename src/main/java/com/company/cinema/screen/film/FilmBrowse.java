package com.company.cinema.screen.film;

import io.jmix.ui.screen.*;
import com.company.cinema.entity.Film;

@UiController("Film.browse")
@UiDescriptor("film-browse.xml")
@LookupComponent("filmsTable")
public class FilmBrowse extends StandardLookup<Film> {
}