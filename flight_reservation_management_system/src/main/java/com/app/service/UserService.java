package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.pojos.Reservation;
import com.app.pojos.User;

public interface UserService {
User authenticateUser(String email, String password);

List<Reservation> fetchReservations(Long userId);



}
