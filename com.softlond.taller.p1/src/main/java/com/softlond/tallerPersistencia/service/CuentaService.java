package com.softlond.tallerPersistencia.service;

import com.softlond.tallerPersistencia.models.CuentaException;
import com.softlond.tallerPersistencia.repository.CuentaRepositoryImpl;

public class CuentaService {
    CuentaRepositoryImpl cuentaRepository;
    public CuentaService(){
        cuentaRepository = new CuentaRepositoryImpl();
    }
    public void guardarCuenta(com.softlond.tallerPersistencia.models.Cuenta cuenta){
        cuentaRepository.guardarCuenta(cuenta);
    }
    public com.softlond.tallerPersistencia.models.Cuenta buscarCuenta(int numeroCuenta){
        return cuentaRepository.buscarCuenta(numeroCuenta);
    }
    public void actualizarCuenta(com.softlond.tallerPersistencia.models.Cuenta cuenta){
        if (cuenta != null){
            cuentaRepository.actualizarCuenta(cuenta);
        }else {
            try {
                throw new CuentaException("La cuenta no existe");
            } catch (CuentaException e) {
                System.out.println("Error al actualizar "+e.getMessage());
            }
        }
    }
}