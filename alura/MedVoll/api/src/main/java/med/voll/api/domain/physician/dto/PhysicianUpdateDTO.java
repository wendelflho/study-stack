package med.voll.api.domain.physician.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.dto.AddressDTO;

public record PhysicianUpdateDTO(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressDTO address
) {
}
