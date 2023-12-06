package com.bci.ejercicio.demo.utils;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorManager {
    
    private Timestamp timestamp;
    private int codigo;
    private String detail;

}

