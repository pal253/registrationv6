package com.api6.service;

import com.api6.entity.Registration;
import com.api6.exception.ResourceNotFoundException;
import com.api6.payload.RegistrationDto;
import com.api6.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private RegistrationRepository rp;
    private ModelMapper mp;


    public RegistrationService(RegistrationRepository rp, ModelMapper mp) {
        this.rp = rp;

        this.mp = mp;
    }

    public List<RegistrationDto> getAllRegistrations(){
        List <Registration> jj = rp.findAll();
        List <RegistrationDto> dtos = jj.stream().map(e->mapToDto(e)).collect(Collectors.toList());
        return dtos;
    }
    public RegistrationDto createRegistration(RegistrationDto dto ){
     Registration registration =  mapToEntity(dto);


Registration savedEntity = rp.save(registration);
RegistrationDto df = mapToDto(savedEntity);



return df;
    }
    public void deleteReg(long id2){
        rp.deleteById(id2);
    }
    public Registration updateReg(long id , Registration registration){
        Registration r = rp.findById(id).get();
        r.setName(registration.getName());
        r.setEmail(registration.getEmail());
        r.setMobile(registration.getMobile());
        Registration u = rp.save(r);
        return u ;
    }
    Registration mapToEntity(RegistrationDto dto){
       Registration registration = mp.map(dto , Registration.class);
       // Registration registration = new Registration();
      //  registration.setName(dto.getName());
       // registration.setEmail(dto.getEmail());
      //  registration.setMobile(dto.getMobile());
        return registration;

    }
   RegistrationDto mapToDto(Registration registration){
       RegistrationDto dto = mp.map(registration , RegistrationDto.class);
      //  RegistrationDto dto = new RegistrationDto();
       // dto.setName(registration.getName());
     //   dto.setEmail(registration.getEmail());
     //   dto.setMobile(registration.getMobile());
        return dto;

    }
    public RegistrationDto getRegById(long id){
        Registration registration = rp.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Record not found")
        ) ;
        return mapToDto(registration);
    }

}
