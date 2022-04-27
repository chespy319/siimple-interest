package com.aplazo.api.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class CreditRequest {

	@Id
	private Long id;

	@NotNull
	@Positive
	private Double amount;

	@NotNull
	@Positive
	private Integer terms;

	@NotNull
	@Positive
	private Double rate;

	@Transient
	private List<PaymentResponse> payments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getTerms() {
		return terms;
	}

	public void setTerms(Integer terms) {
		this.terms = terms;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public List<PaymentResponse> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentResponse> payments) {
		this.payments = payments;
	}

}
