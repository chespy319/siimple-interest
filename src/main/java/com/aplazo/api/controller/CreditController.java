package com.aplazo.api.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplazo.api.database.DatabaseSeeder;
import com.aplazo.api.model.CreditRequest;
import com.aplazo.api.model.PaymentResponse;
import com.aplazo.api.repository.CreditRepository;
import com.aplazo.api.repository.PaymentRepository;

@RestController
@RequestMapping(path = "credits", produces = "application/json", consumes = "application/json")
public class CreditController {

	@Autowired
	private CreditRepository creditRepo;

	@Autowired
	private PaymentRepository paymentRepo;

	@Autowired
	private DatabaseSeeder database;

	@PostConstruct
	public void init() {
		database.createDatabase();
	}

	@GetMapping
	public Iterable<CreditRequest> findAll() {
		Iterable<CreditRequest> credits = creditRepo.findAll();
		credits.forEach(credit -> credit.setPayments(paymentRepo.findByCredit(credit.getId())));
		return credits;
	}

	@PostMapping
	public CreditRequest createCredit(@RequestBody @Valid CreditRequest request) {
		CreditRequest credit = creditRepo.save(request);
		credit.setPayments(new ArrayList<>(request.getTerms()));
		double simpleInterest = (request.getAmount() * request.getTerms() * request.getRate()) / 100;
		double paymentAmount = (request.getAmount() + simpleInterest) / request.getTerms();
		for (int i = 1; i <= request.getTerms(); i++) {
			PaymentResponse payment = new PaymentResponse();
			payment.setNumber(i);
			payment.setAmount(paymentAmount);
			payment.setDate(LocalDate.now().plusWeeks(i));
			payment.setCredit(credit.getId());
			paymentRepo.save(payment);
			credit.getPayments().add(payment);
		}
		return request;
	}

}
