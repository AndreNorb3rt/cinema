package com.company.cinema.app;

import com.company.cinema.entity.Session;
import com.company.cinema.entity.Ticket;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Deleter {
    @Autowired
    private DataManager dataManager;

    private boolean checkSessionBeforeDelete(Session x) {//доделать пункт 5
        List<Ticket> tickets = dataManager.load(Ticket.class)
                .query("select c from Ticket c")
                .list();
        for (int i = 0; i < tickets.size(); i++) {
            if (x.getCinemaHall() == tickets.get(i).getSession().getCinemaHall())
                return true;
        }
        return false;
    }
}