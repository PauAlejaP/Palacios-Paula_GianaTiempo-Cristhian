package com.backend.parcial.Odontologo;


import com.backend.parcial.model.Odontologo;
import com.backend.parcial.service.OdontologoService;

public class Test {
    public static void main(String[] args) {
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("Juan");
        odontologo.setId(1);
        odontologo.setApellido("Perez");
        odontologo.setMatricula(123);
        System.out.println(odontologo.getNombre());

        OdontologoService odontologoService = new OdontologoService();
        odontologoService.insertOdontonlogo(odontologo);
    }

}

