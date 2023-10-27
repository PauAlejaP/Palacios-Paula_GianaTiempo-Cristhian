package com.backend.parcial.dao;

public interface IDao<T> {
    T insertOdont(T odontologo);
    T buscarPorId(int id);
}
