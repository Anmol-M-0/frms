package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
