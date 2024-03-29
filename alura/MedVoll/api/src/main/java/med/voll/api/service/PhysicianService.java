package med.voll.api.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.physician.Physician;
import med.voll.api.domain.physician.dto.PhysicianDTO;
import med.voll.api.domain.physician.dto.PhysicianListDTO;
import med.voll.api.domain.physician.dto.PhysicianUpdateDTO;
import med.voll.api.repository.PhysicianRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhysicianService {

    private final PhysicianRepository physicianRepository;

    public Physician createPhysician(PhysicianDTO physicianDTO) {
        Physician physician = new Physician(physicianDTO);
        return physicianRepository.save(physician);
    }

    public Page<PhysicianListDTO> physicianList(Pageable pageable) {
        /*
        * O findAll devolve um page e o page já tem um map diretamente
        * não precisa do toList também
        * */
        return physicianRepository
                .findAllByActiveTrue(pageable)
                .map(PhysicianListDTO::new);
    }

    public Physician updatePhysician(PhysicianUpdateDTO physicianUpdate) {
        var physician = physicianRepository.getReferenceById(physicianUpdate.id());
        physician.updateInfo(physicianUpdate);
        return physician;
    }

    public void deletePhysician(Long id) {
        var physician = physicianRepository.getReferenceById(id);
        physician.delete();
    }

    public Physician detailPhysician(Long id) {
        return physicianRepository.getReferenceById(id);
    }
}
