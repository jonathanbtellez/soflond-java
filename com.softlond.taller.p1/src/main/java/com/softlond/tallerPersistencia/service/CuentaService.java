package com.softlond.tallerPersistencia.service;

import com.softlond.tallerPersistencia.models.Cuenta;
import com.softlond.tallerPersistencia.repository.CuentaRepositoryImpl;

public class CuentaService {
    CuentaRepositoryImpl cuentaRepository;
    private CuentaService(){
        cuentaRepository = new CuentaRepositoryImpl();
    }
    public void guardarCuenta(Cuenta cuenta){
        cuentaRepository.guardarCuenta(cuenta);
    }
    public Cuenta buscarCuenta(int numeroCuenta){
        return cuentaRepository.buscarCuenta(numeroCuenta);
    }
    public void actualizarCuenta(int numeroCuenta, Cuenta cuenta){
        cuentaRepository.actualizarCuenta(numeroCuenta, cuenta);
    }
}