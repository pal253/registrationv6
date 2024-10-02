package com.api6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class A {

    public static void main(String[] args) {
       List <Employee> employees = Arrays.asList(
                new Employee(1, "mike"),
                new Employee(2, "santa"),
                new Employee(3, "earl")

        );
       employees.stream().map(e->mapToDto(e)).collect(Collectors.toList());
    }



static EmployeeDto mapToDto(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        return dto;
}





    }












