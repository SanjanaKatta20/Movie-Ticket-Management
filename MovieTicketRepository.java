package com.example.movieticketmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movieticketmanagement.model.MovieTicket;

public interface MovieTicketRepository extends JpaRepository<MovieTicket, Long> {

}
