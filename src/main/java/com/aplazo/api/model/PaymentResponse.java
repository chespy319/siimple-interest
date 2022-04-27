package com.aplazo.api.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentResponse {

	@Id
	private Long id;

	@JsonIgnore
	private Long credit;

	@JsonProperty("payment_number")
	private Integer number;

	private Double amount;

	@JsonProperty("payment_date")
	private LocalDate date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCredit() {
		return credit;
	}

	public void setCredit(Long credit) {
		this.credit = credit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getAmount() {
		BigDecimal bd = BigDecimal.valueOf(amount);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public void setAmount(Double amount) {
		BigDecimal bd = BigDecimal.valueOf(amount);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		this.amount = bd.doubleValue();
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
