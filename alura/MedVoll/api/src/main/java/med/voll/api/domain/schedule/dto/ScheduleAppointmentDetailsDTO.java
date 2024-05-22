package med.voll.api.domain.schedule.dto;

import java.time.LocalDateTime;

public record ScheduleAppointmentDetailsDTO(
        Long id,
        Long idPhysician,
        Long idPatient,
        LocalDateTime dateTime
) {
}
