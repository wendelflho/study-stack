package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.domain.schedule.dto.ScheduleAppointmentDTO;
import med.voll.api.domain.schedule.dto.ScheduleAppointmentDetailsDTO;
import med.voll.api.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    @Transactional
    public ResponseEntity<ScheduleAppointmentDetailsDTO> schedule(
            @RequestBody @Valid ScheduleAppointmentDTO scheduleAppointment
    ) {
        appointmentService.schedule(scheduleAppointment);

        return ResponseEntity.ok(new ScheduleAppointmentDetailsDTO(null, null, null, null));
    }
}
