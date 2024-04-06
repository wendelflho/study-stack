package med.voll.api.domain.schedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.physician.Specialty;

import java.time.LocalDateTime;

public record ScheduleAppointmentDTO(
        Long idPhysician,

        @NotNull
        Long idPatient,

        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dateTime,

        Specialty specialty
) {
}
