package med.voll.api.controller;

import med.voll.api.model.Physician;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "physician")
public class PhysicianController {

    @PostMapping
    public void create(@RequestBody Physician physician) {
        System.out.println(physician);
    }
}
