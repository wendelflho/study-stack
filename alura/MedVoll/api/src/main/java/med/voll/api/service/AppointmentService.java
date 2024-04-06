package med.voll.api.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.physician.Physician;
import med.voll.api.domain.schedule.Schedule;
import med.voll.api.domain.schedule.dto.ScheduleAppointmentDTO;
import med.voll.api.infra.exception.ValidateException;
import med.voll.api.repository.PatientRepository;
import med.voll.api.repository.PhysicianRepository;
import med.voll.api.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final ScheduleRepository scheduleRepository;
    private final PhysicianRepository physicianRepository;
    private final PatientRepository patientRepository;

    public void schedule(ScheduleAppointmentDTO scheduleAppointment) {
        if (scheduleAppointment.idPhysician() != null
                && !physicianRepository.existsById(scheduleAppointment.idPhysician())) {
            throw new ValidateException("O id do médico informado não existe");
        }

        var physician = choosePhysician(scheduleAppointment);

        var patient = patientRepository.getReferenceById(scheduleAppointment.idPatient());

        var appointment = new Schedule(
                null,
                physician,
                patient,
                scheduleAppointment.dateTime()
        );

        scheduleRepository.save(appointment);
    }

    private Physician choosePhysician(ScheduleAppointmentDTO scheduleAppointment) {
        if (scheduleAppointment.idPhysician() != null) {
            return physicianRepository.getReferenceById(scheduleAppointment.idPhysician());
        }

        if (scheduleAppointment.specialty() == null) {
            throw new ValidateException("Especialidade é obrigatória quando médico não for escolhido");
        }

        return physicianRepository.findRandomPhysicianAvailableAtDate(
                scheduleAppointment.specialty(),
                scheduleAppointment.dateTime()
        );
    }
}
