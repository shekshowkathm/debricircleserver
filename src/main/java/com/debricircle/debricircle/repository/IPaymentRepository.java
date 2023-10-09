package com.debricircle.debricircle.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.debricircle.debricircle.model.OrderRequest;

@Repository
public interface IPaymentRepository extends MongoRepository<OrderRequest, String> {

}
