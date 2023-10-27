package com.backend.parcial.dao.impl;
import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
public class OdontologoDaoMemoria implements IDao<Odontologo> {
    private final Logger LOGGER = Logger.getLogger(OdontologoDaoMemoria.class.getName());
    private List<Odontologo> odontologoRepository;

    public OdontologoDaoMemoria() {
        this.odontologoRepository = new ArrayList<>();
    }

    @Override
    public Odontologo insertOdont(Odontologo odontologo) {
        return null;
    }

    @Override
    public Odontologo buscarPorId(int id) {
        Odontologo odontologoBuscado = odontologoRepository.get(id-1);
        if (odontologoBuscado != null)
            LOGGER.info("El odontologo con id " + id + "se ha encontrado");
        else LOGGER.info("El odontologo con id " + id + "no se ha encontrado");
        return odontologoBuscado;
    }


    public List<Odontologo> getOdontologoRepository() { return odontologoRepository; }
}

