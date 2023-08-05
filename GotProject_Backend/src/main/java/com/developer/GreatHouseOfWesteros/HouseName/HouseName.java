package com.developer.GreatHouseOfWesteros.HouseName;
import java.util.List;

public class HouseName<T> {


	    private List<T> listOfStrings;
	    private T singleString;

	    public HouseName(List<T> listOfStrings) {
	        this.listOfStrings = listOfStrings;
	    }

	    public HouseName(T singleString) {
	        this.singleString = singleString;
	    }

	    public List<T> getListOfStrings() {
	        return listOfStrings;
	    }

	    public T getSingleString() {
	        return singleString;
	    }

	    public boolean isListOfStrings() {
	        return listOfStrings != null;
	    }

	    public boolean isSingleString() {
	        return singleString != null;
	    }
	}

