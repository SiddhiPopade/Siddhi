package com.flightbookingsystem.flightsearch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbookingsystem.flightsearch.entity.UserEntity;



@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	public Optional<UserEntity> findById(String id);
}