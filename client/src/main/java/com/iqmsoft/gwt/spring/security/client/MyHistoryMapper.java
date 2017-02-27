package com.iqmsoft.gwt.spring.security.client;



import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.iqmsoft.gwt.spring.security.places.*;


@WithTokenizers({ContactPlace.Tokenizer.class, HomePlace.Tokenizer.class, UsersPlace.Tokenizer.class})
public interface MyHistoryMapper extends PlaceHistoryMapper  {

}

