package com.berzinc.pettracker.appointments;

import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
