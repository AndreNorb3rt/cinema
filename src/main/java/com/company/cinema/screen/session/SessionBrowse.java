package com.company.cinema.screen.session;

import com.company.cinema.screen.ticket.ShowTicketsBrowse;
import io.jmix.ui.Notifications;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.Screens;
import io.jmix.ui.action.BaseAction;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.Table;
import io.jmix.ui.screen.*;
import com.company.cinema.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Session_.browse")
@UiDescriptor("session-browse.xml")
@LookupComponent("sessionsTable")
public class SessionBrowse extends StandardLookup<Session> {
    @Autowired
    private ScreenBuilders screenBuilders;
    @Autowired
    private Notifications notifications;
    @Autowired
    private Screens screens;
    @Autowired
    private Table<Session> sessionsTable;



    @Subscribe("showBtn")
    public void onShowBtnClick(Button.ClickEvent event) {
        Session selectedSession = sessionsTable.getSingleSelected();
        ShowTicketsBrowse test = screens.create(ShowTicketsBrowse.class);
        test.setSelectedSession(selectedSession);
        screens.show(test);
        /*screenBuilders.screen(this)
                .withScreenClass(ShowTicketsBrowse.class)
                .withOptions(new ShowTicketsBrowse(selectedSession))
                *//*.withAfterCloseListener(e -> {
                    notifications.create().withCaption("Closed").show();
                })*//*
                .build()
                .show();*/
    }
}