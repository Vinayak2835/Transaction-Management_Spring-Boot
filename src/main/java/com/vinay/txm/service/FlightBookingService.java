package com.vinay.txm.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vinay.txm.dto.FlightBookingAcknowledgement;
import com.vinay.txm.dto.FlightBookingRequest;
import com.vinay.txm.entity.PassengerInfo;
import com.vinay.txm.entity.PaymentInfo;
import com.vinay.txm.repo.PassengerRepository;
import com.vinay.txm.repo.PaymentRepository;
import com.vinay.txm.utils.PaymentUtils;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerRepository passengerInfoRepository;

	@Autowired
	private PaymentRepository paymentInfoRepository;

	@Transactional
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {

		PassengerInfo passengerInfo = request.getPassengerInfo();
		this.passengerInfoRepository.save(passengerInfo);

		PaymentInfo paymentInfo = request.getPaymentInfo();

		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

		paymentInfo.setPassengerId(passengerInfo.getPId());
		paymentInfo.setAmount(passengerInfo.getFare());

		paymentInfoRepository.save(paymentInfo);
		return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(),
				UUID.randomUUID().toString().split("-")[0], passengerInfo);
	}
}
