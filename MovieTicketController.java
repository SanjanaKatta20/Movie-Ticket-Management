package com.example.movieticketmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieticketmanagement.model.MovieTicket;
import com.example.movieticketmanagement.service.MovieTicketService;

@RestController
@RequestMapping("/api/tickets")
public class MovieTicketController {
    @Autowired
    private MovieTicketService movieTicketService;

    @GetMapping
    public List<MovieTicket> getAllTickets() {
        return movieTicketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieTicket> getTicketById(@PathVariable Long id) {
        MovieTicket ticket = movieTicketService.getTicketById(id);
        return ticket != null ? new ResponseEntity<>(ticket, HttpStatus.OK) :
                                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public MovieTicket createTicket(@RequestBody MovieTicket ticket) {
        return movieTicketService.saveTicket(ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieTicket> updateTicket(@PathVariable Long id, @RequestBody MovieTicket ticket) {
        MovieTicket existingTicket = movieTicketService.getTicketById(id);
        if (existingTicket != null) {
            ticket.setId(id);
            return new ResponseEntity<>(movieTicketService.saveTicket(ticket), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        movieTicketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}