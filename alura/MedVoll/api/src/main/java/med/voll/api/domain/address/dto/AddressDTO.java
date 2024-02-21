package med.voll.api.domain.address.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.Address;

public record AddressDTO(

        @NotBlank
        String publicPlace,

        @NotBlank
        String district,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zipCode,

        @NotBlank
        String city,

        @NotBlank
        String fu,

        String number,

        String complement
) {
        public Address toAddress(Address address) {
                address.updateInfo(this);
                return address;
        }
}
