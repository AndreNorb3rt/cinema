package com.company.cinema.screen.session;

import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import com.company.cinema.entity.Session;

@UiController("Session_.browse")
@UiDescriptor("session-browse.xml")
@LookupComponent("sessionsTable")
public class SessionBrowse extends StandardLookup<Session> {
    @Subscribe("infoBtn")
    public void onInfoBtnClick(Button.ClickEvent event) {
        
    }
}