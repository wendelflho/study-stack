package med.voll.api.domain.patient.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.dto.AddressDTO;

public record PatientUpdateDTO(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressDTO address
) {
}
