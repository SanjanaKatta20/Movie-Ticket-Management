package com.example.movieticketmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieticketmanagement.model.MovieTicket;
import com.example.movieticketmanagement.repository.MovieTicketRepository;

@Service
public class MovieTicketService {
    @Autowired
    private MovieTicketRepository movieTicketRepository;

    public List<MovieTicket> getAllTickets() {
        return movieTicketRepository.findAll();
    }

    public MovieTicket getTicketById(Long id) {
        return movieTicketRepository.findById(id).orElse(null);
    }

    public MovieTicket saveTicket(MovieTicket ticket) {
        return movieTicketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        movieTicketRepository.deleteById(id);
    }
}
