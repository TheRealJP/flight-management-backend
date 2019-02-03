package com.badwitsoftware.flightreservation.user;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
