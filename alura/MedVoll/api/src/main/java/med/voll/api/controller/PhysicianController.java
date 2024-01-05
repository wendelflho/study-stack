package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.Physician;
import med.voll.api.model.dto.PhysicianDTO;
import med.voll.api.model.dto.PhysicianListDTO;
import med.voll.api.model.dto.PhysicianUpdateDTO;
import med.voll.api.repository.PhysicianRepository;
import med.voll.api.service.PhysicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "physician")
public class PhysicianController {

    @Autowired
    private PhysicianService physicianService;

    @PostMapping
    @Transactional
    public ResponseEntity<Physician> create(@RequestBody @Valid PhysicianDTO physicianDTO) {
        Physician physician = physicianService.createPhysician(physicianDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(physician);
    }

    @GetMapping
    public ResponseEntity<Page<PhysicianListDTO>> physicianList(
            @PageableDefault(size = 10, sort = {"name"}) Pageable pageable
    ) {
        Page<PhysicianListDTO> body = physicianService.physicianList(pageable);
        return ResponseEntity.ok(body);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Physician> updatePhysician(@RequestBody @Valid PhysicianUpdateDTO physicianUpdate) {
        physicianService.updatePhysician(physicianUpdate);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Physician> deletePhysician(@PathVariable Long id) {
        physicianService.deletePhysician(id);
        return ResponseEntity.ok().build();
    }

}
