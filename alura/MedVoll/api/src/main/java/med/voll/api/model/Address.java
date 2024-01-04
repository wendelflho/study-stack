package med.voll.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.dto.AddressDTO;

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
}
