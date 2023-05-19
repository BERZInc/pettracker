package com.berzinc.pettracker.appointments;

import org.springframework.data.jpa.repository.JpaRepository;

/**		
 * 
 * @author Erik Ziegler
 *
 */

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
