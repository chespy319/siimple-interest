package com.aplazo.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.aplazo.api.model.CreditRequest;

public interface CreditRepository extends CrudRepository<CreditRequest, Long> {

}
