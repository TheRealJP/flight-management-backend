package com.travelab.reservation.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByFirstNameAndLastName(String firstName, String lastName);

	public User findByEmail(String email);
}
