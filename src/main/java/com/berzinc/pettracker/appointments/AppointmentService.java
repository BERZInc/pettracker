package com.berzinc.pettracker.appointments; 

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berzinc.pettracker.users.UserRepository;
import com.berzinc.pettracker.users.User;
/**		
 * 
 * @author Erik Ziegler
 *
 */
@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Autowired
    private UserRepository userRepository;

    public List<Appointment> listAllAppointments(String username) {
        User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new IllegalStateException("user not found " + username));
        return appointmentRepository.findAllByUser(user);
    }
     
    public Appointment createAppointment(Appointment appointment, String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new IllegalStateException("user not found " + username));
        appointment.setUser(user);
    	return appointmentRepository.save(appointment);
    }
     
    public Appointment getAppointment(Long id) {
        return appointmentRepository.findById(id).get();
    }
     
    public void deleteAppointment(Long id) {
    	appointmentRepository.deleteById(id);
    }
    
    public Appointment updateAppointment(Long id, Appointment appointmentDetails) {
    	Appointment appointment = appointmentRepository.findById(id).get();
    	appointment.setFullName(appointmentDetails.getFullName());
    	appointment.setPetName(appointmentDetails.getPetName());
    	appointment.setVetName(appointmentDetails.getVetName());
    	appointment.setDate(appointmentDetails.getDate());
    	appointment.setTime(appointmentDetails.getTime());
    	appointment.setNotes(appointmentDetails.getNotes());
        
        return appointmentRepository.save(appointment);                                
    }
}
