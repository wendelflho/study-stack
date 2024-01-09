package med.voll.api.service;

import med.voll.api.model.Physician;
import med.voll.api.model.dto.PhysicianDTO;
import med.voll.api.model.dto.PhysicianListDTO;
import med.voll.api.model.dto.PhysicianUpdateDTO;
import med.voll.api.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhysicianService {

    @Autowired
    private PhysicianRepository physicianRepository;

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
