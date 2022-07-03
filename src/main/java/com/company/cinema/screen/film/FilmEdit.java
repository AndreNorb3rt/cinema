package com.company.cinema.screen.film;

import io.jmix.ui.screen.*;
import com.company.cinema.entity.Film;

@UiController("Film.edit")
@UiDescriptor("film-edit.xml")
@EditedEntityContainer("filmDc")
public class FilmEdit extends StandardEditor<Film> {
}