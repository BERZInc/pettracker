package com.berzinc.pettracker.appointments; 

import java.util.List;
 
import jakarta.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    public List<Appointment> listAllAppointments() {
        return appointmentRepository.findAll();
    }
     
    public Appointment createAppointment(Appointment appointment) {
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
    	appointment.setUser_id(appointmentDetails.getUser_id());
    	appointment.setPet_id(appointmentDetails.getPet_id());
    	appointment.setVet_id(appointmentDetails.getVet_id());
    	appointment.setDate(appointmentDetails.getDate());
    	appointment.setTime(appointmentDetails.getTime());
        
        return appointmentRepository.save(appointment);                                
    }
}
