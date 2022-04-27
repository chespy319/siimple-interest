package com.aplazo.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aplazo.api.model.PaymentResponse;

public interface PaymentRepository extends CrudRepository<PaymentResponse, Long> {

	List<PaymentResponse> findByCredit(Long credit);

}
