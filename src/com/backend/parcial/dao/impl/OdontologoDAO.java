package com.backend.parcial.dao.impl;

import com.backend.parcial.dao.H2Connection;
import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class OdontologoDAO implements IDao<Odontologo> {
    private final Logger LOGGER = Logger.getLogger(OdontologoDAO.class.getName());

    public Odontologo insertOdont(Odontologo odontologo) {
        Connection connection = null;
        Odontologo odontologoPersistido = null;
        try {
            connection = new H2Connection().getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO odontologos (nombre, apellido, matricula) VALUES (?, ?, ?)");
            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setInt(3, odontologo.getMatricula());
            preparedStatement.execute();

            connection.commit();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                odontologoPersistido = new Odontologo(resultSet.getInt(1), odontologo.getNombre(), odontologo.getApellido(), odontologo.getMatricula());
            }

            LOGGER.info("Se ha insertado el odontologo " + odontologoPersistido);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Ey Ey Ey... hay problemas");
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }
            return odontologoPersistido;
        }

    }

    public Odontologo buscarPorId(int id) {
        Odontologo odontologo = null;

        Connection connection = null;
        try {
            connection = new H2Connection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM odontologos WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                odontologo = new Odontologo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
            }
            LOGGER.info("Se ha encontrado el odontologo " + odontologo);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Ey Ey Ey... hay problemas");
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }
            return odontologo;
        }
    }
}