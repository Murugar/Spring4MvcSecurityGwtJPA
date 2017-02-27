package com.iqmsoft.gwt.spring.security.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.iqmsoft.gwt.spring.security.client.ClientFactory;
import com.iqmsoft.gwt.spring.security.places.ContactPlace;
import com.iqmsoft.gwt.spring.security.places.HomePlace;
import com.iqmsoft.gwt.spring.security.places.UsersPlace;
import com.iqmsoft.gwt.spring.security.ui.MainPage;

public class MainPageActivity extends AbstractActivity implements MainPage.Presenter {
	
	MainPage mainPage;
	PlaceController controller;
	Place currentPlace;
	
	public MainPageActivity(ClientFactory factory, Place place) {
		this.mainPage = factory.getMainPageView();
		this.controller = factory.getPlaceController();
		this.currentPlace = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus bus) {
		panel.setWidget(mainPage);
	}
	
	public void refreshPlace(Place place){
		this.currentPlace = place;
		
		GWT.log(place.toString());
		
		if(place instanceof HomePlace){
			placeChangeWithoutClickEvent("home");
		}else if(place instanceof ContactPlace){
			placeChangeWithoutClickEvent("contact");
		}else if(place instanceof UsersPlace){
			placeChangeWithoutClickEvent("users");
		}
		
	}

	@Override
	public void placeChangeWithoutClickEvent(String placeName) {
		mainPage.getIronPagesElement().select(placeName);
      	mainPage.getPaperMenu().select(placeName);
		
	}



}
