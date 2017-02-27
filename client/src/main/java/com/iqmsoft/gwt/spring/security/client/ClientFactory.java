package com.iqmsoft.gwt.spring.security.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.iqmsoft.gwt.spring.security.ui.MainPage;


public interface ClientFactory {
     MainPage getMainPageView();
     EventBus getEventBus();
     PlaceController getPlaceController();
}
