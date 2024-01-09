package med.voll.api.model.dto;

import jakarta.validation.constraints.NotNull;

public record PhysicianUpdateDTO(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressDTO address
) {
}
