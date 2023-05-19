package com.berzinc.pettracker.appointments;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berzinc.pettracker.users.User;

/**		
 * 
 * @author Erik Ziegler
 *
 */

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByUser(User user);
}
