package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.exceptions.UserHandlingException;
import com.app.pojos.Reservation;
import com.app.pojos.User;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public User authenticateUser(String email, String password) {
		Optional<User> user = repository.findByEmailAndPassword(email,password);
		return user.orElseThrow(() -> new UserHandlingException("invalid id or password"));//invalid login if this exception is thrown
	}

	@Override
	public List<Reservation> fetchReservations(Long userId) {
		User user = repository.findById(userId).orElseThrow(()->new UserHandlingException("an error occured: invalid userId"));
		return user.getReservations();
	}

}
