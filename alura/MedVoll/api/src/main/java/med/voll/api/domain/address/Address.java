package med.voll.api.domain.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.dto.AddressDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(name = "public_place")
    private String publicPlace;
    private String district;

    @Column(name = "zip_code")
    private String zipCode;
    private String city;
    private String fu;
    private String number;
    private String complement;

    public Address(AddressDTO address) {
        this.publicPlace = address.publicPlace();
        this.district = address.district();
        this.zipCode = address.zipCode();
        this.city = address.city();
        this.fu = address.fu();
        this.number = address.number();
        this.complement = address.complement();
    }

    public void updateInfo(AddressDTO address) {
        if (address.publicPlace() != null) {
            this.publicPlace = address.publicPlace();
        }
        if (address.district() != null) {
            this.district = address.district();
        }
        if (address.zipCode() != null) {
            this.zipCode = address.zipCode();
        }
        if (address.city() != null) {
            this.city = address.city();
        }
        if (address.fu() != null) {
            this.fu = address.fu();
        }
        if (address.number() != null) {
            this.number = address.number();
        }
        if (address.complement() != null) {
            this.complement = address.complement();
        }
    }
}
