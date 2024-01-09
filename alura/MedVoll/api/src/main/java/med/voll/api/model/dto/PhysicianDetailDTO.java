package med.voll.api.model.dto;

import med.voll.api.model.Address;
import med.voll.api.model.Physician;
import med.voll.api.model.Specialty;

public record PhysicianDetailDTO(
        Long id,
        String name,
        String email,
        String crm,
        String phone,
        Specialty specialty,
        Address address
) {
    public PhysicianDetailDTO(Physician physician) {
        this(
                physician.getId(),
                physician.getName(),
                physician.getEmail(),
                physician.getCrm(),
                physician.getPhone(),
                physician.getSpecialty(),
                physician.getAddress()
        );
    }
}
