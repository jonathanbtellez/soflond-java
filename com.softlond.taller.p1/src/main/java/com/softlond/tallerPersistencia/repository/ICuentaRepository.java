package com.softlond.tallerPersistencia.repository;

import com.softlond.tallerPersistencia.models.Cuenta;

public interface ICuentaRepository {
    public Cuenta buscarCuenta(int numeroCuenta);
    public void guardarCuenta(Cuenta cuenta);
    public void actualizarCuenta(int numeroCuenta, Cuenta cuenta);
    public void eliminarCuenta(int numeroCuenta);
}
