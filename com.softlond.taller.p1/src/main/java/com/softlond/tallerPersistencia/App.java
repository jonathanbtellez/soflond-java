package com.softlond.tallerPersistencia;

import com.softlond.tallerPersistencia.GUI.GUI_Cuenta;
import com.softlond.tallerPersistencia.models.Cuenta;
import com.softlond.tallerPersistencia.models.CuentaAhorros;
import com.softlond.tallerPersistencia.models.CuentaCorriente;
import com.softlond.tallerPersistencia.models.CuentaException;
import com.softlond.tallerPersistencia.service.CuentaService;

public class App {
    public static void main(String[] args)  {
        CuentaService cuentaService = new CuentaService();
        Cuenta cuenta  = cuentaService.buscarCuenta(2);
        System.out.println(cuenta.getTipoCuenta());
        GUI_Cuenta guiCuenta = new GUI_Cuenta();

        try {
            guiCuenta.iniciar();
        } catch (CuentaException e) {
            throw new RuntimeException(e);
        }
    }
}
