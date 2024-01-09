package med.voll.api.model.dto;

import med.voll.api.model.Physician;
import med.voll.api.model.Specialty;

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
