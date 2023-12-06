package com.bci.ejercicio.demo.domain.repository;

import org.hibernate.type.UUIDBinaryType;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bci.ejercicio.demo.domain.entity.Phone;

public interface PhoneRepository  extends JpaRepository<Phone, UUIDBinaryType>{
    
}
