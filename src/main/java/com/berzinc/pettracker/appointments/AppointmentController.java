package com.berzinc.pettracker.appointments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**		
 * 
 * @author Erik Ziegler
 *
 */
@RestController
@RequestMapping(path="/api")
public class AppointmentController {
    
    @Autowired
    private AppointmentService appointmentService;

    @CrossOrigin
    @RequestMapping(value="/appointments", method=RequestMethod.POST)
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @CrossOrigin
    @RequestMapping(value="/appointments", method=RequestMethod.GET)
    public List<Appointment> listAllAppointments() {
        return appointmentService.listAllAppointments();
    }

    @CrossOrigin
    @RequestMapping(value="/appointments/{id}", method=RequestMethod.PUT)
    public Appointment updateAppointment(@PathVariable(value = "id") Long id, @RequestBody Appointment appointmentDetails) {
        return appointmentService.updateAppointment(id, appointmentDetails);
    }

    @RequestMapping(value="/appointments/{id}", method=RequestMethod.DELETE)
    public void deleteAppointment(@PathVariable(value = "id") Long id) {
    	appointmentService.deleteAppointment(id);
    }
}
