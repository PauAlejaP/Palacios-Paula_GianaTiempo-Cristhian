package com.backend.parcial.service;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.dao.impl.OdontologoDAO;
import com.backend.parcial.dao.impl.OdontologoDaoMemoria;
import com.backend.parcial.model.Odontologo;

public class OdontologoService {
    private IDao<Odontologo> odontologoDao;


    public Odontologo insertOdontologoMemoria (Odontologo odontologo){
        odontologoDao = new OdontologoDaoMemoria();
        return odontologoDao.insertOdont(odontologo);
    }

        public Odontologo insertOdontonlogo (Odontologo odontologo){
            OdontologoDAO odontologoDao = new OdontologoDAO();
            return odontologoDao.insertOdont(odontologo);
        }
        public Odontologo buscarPorId (int id){
            return odontologoDao.buscarPorId(id);
        }
    }

