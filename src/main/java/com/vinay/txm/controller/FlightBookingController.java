package com.vinay.txm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.txm.dto.FlightBookingAcknowledgement;
import com.vinay.txm.dto.FlightBookingRequest;
import com.vinay.txm.service.FlightBookingService;

@RestController
public class FlightBookingController {

	@Autowired
	private FlightBookingService service;

	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
		return service.bookFlightTicket(request);
	}

}
