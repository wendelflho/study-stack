package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.Physician;
import med.voll.api.model.dto.PhysicianDTO;
import med.voll.api.model.dto.PhysicianDetailDTO;
import med.voll.api.model.dto.PhysicianListDTO;
import med.voll.api.model.dto.PhysicianUpdateDTO;
import med.voll.api.service.PhysicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "physician")
public class PhysicianController {

    @Autowired
    private PhysicianService physicianService;

    @PostMapping
    @Transactional
    public ResponseEntity<PhysicianDetailDTO> create(
            @RequestBody @Valid PhysicianDTO physicianDTO,
            UriComponentsBuilder uriBuilder
    ) {
        Physician physician = physicianService.createPhysician(physicianDTO);

        var uri = uriBuilder.path("/physician/{id}").buildAndExpand(physician.getId()).toUri();

        return ResponseEntity.created(uri).body(new PhysicianDetailDTO(physician));
    }

    @GetMapping
    public ResponseEntity<Page<PhysicianListDTO>> physicianList(
            @PageableDefault(size = 10, sort = {"id"}) Pageable pageable
    ) {
        Page<PhysicianListDTO> page = physicianService.physicianList(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhysicianDetailDTO> detailPhysician(@PathVariable Long id) {
        Physician physician = physicianService.detailPhysician(id);
        return ResponseEntity.ok(new PhysicianDetailDTO(physician));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PhysicianDetailDTO> updatePhysician(@RequestBody @Valid PhysicianUpdateDTO physicianUpdate) {
        var physician = physicianService.updatePhysician(physicianUpdate);
        return ResponseEntity.ok(new PhysicianDetailDTO(physician));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Physician> deletePhysician(@PathVariable Long id) {
        physicianService.deletePhysician(id);
        return ResponseEntity.noContent().build();
    }

}
