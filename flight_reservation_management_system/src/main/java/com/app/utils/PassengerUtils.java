package com.app.utils;

import com.app.pojos.Passenger;
import com.app.pojos.PassengerInfo;

public interface PassengerUtils {
	static Passenger addInfo(PassengerInfo info) {
    	return new Passenger(info.getFirstName(), info.getMiddleName(), info.getLastName(), info.getEmail(), info.getPhone());
    }
}
