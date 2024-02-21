package med.voll.api.domain.physician.dto;

import med.voll.api.domain.physician.Physician;
import med.voll.api.domain.physician.Specialty;

public record PhysicianListDTO(
        Long id,
        String name,
        String email,
        String crm,
        Specialty specialty
) {
    public PhysicianListDTO(Physician physician) {
        this(physician.getId(), physician.getName(), physician.getEmail(), physician.getCrm(), physician.getSpecialty());
    }
}
