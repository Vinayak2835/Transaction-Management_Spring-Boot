package com.vinay.txm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinay.txm.entity.PassengerInfo;

public interface PassengerRepository extends JpaRepository<PassengerInfo, Integer> {

}
