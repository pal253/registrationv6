package com.api6.controller;

import com.api6.entity.Registration;
import com.api6.payload.RegistrationDto;
import com.api6.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private RegistrationService rs;

    public RegistrationController(RegistrationService rs) {
        this.rs = rs;
    }

    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getRegistrations() {
        List<RegistrationDto> dtos = rs.getAllRegistrations();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAllRegistration(
            @Valid @RequestBody RegistrationDto registrationDto , BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.CREATED);
        }
        RegistrationDto reg = rs.createRegistration(registrationDto);
        return new ResponseEntity<>(reg, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(@RequestParam long id) {
        rs.deleteReg(id);
        return new ResponseEntity<>("deleted by id", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateAllRegistrations(
            @PathVariable long id, @RequestBody Registration registration) {
        Registration gh = rs.updateReg(id, registration);
        return new ResponseEntity<>(gh, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getRegistrationById(
            @PathVariable long id
    ) {
       RegistrationDto dto = rs.getRegById(id);
       return new ResponseEntity<>(dto , HttpStatus.OK);

    }

}
