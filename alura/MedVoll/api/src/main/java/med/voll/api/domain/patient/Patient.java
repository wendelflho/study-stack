package med.voll.api.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;
import med.voll.api.domain.patient.dto.PatientDTO;
import med.voll.api.domain.patient.dto.PatientUpdateDTO;
import org.hibernate.validator.constraints.br.CPF;

@Table(name = "patients")
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @Column(name = "tax_id")
    @CPF
    private String taxId;

    @Embedded
    private Address address;

    private Boolean active;

    public Patient(PatientDTO patientDTO) {
        this.active = true;
        this.name = patientDTO.name();
        this.email = patientDTO.email();
        this.phone = patientDTO.phone();
        this.taxId = patientDTO.taxId();
        this.address = new Address(patientDTO.address());
    }

    public void updateInfo(PatientUpdateDTO patientUpdate) {
        if (patientUpdate.name() != null) {
            this.name = patientUpdate.name();
        }
        if (patientUpdate.phone() != null) {
            this.phone = patientUpdate.phone();
        }
        if (patientUpdate.address() != null) {
            this.address.updateInfo(patientUpdate.address());
        }
    }

    public void delete() {
        this.active = false;
    }
}
