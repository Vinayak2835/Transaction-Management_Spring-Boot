package com.vinay.txm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinay.txm.entity.PaymentInfo;

public interface PaymentRepository extends JpaRepository<PaymentInfo, String>{

}
