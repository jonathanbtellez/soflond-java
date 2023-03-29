package com.softlond.tallerPersistencia;

import com.softlond.tallerPersistencia.models.Cuenta;
import com.softlond.tallerPersistencia.models.CuentaAhorros;
import com.softlond.tallerPersistencia.models.CuentaCorriente;
import com.softlond.tallerPersistencia.repository.CuentaRepositoryImpl;
import com.softlond.tallerPersistencia.repository.ICuentaRepository;

public class main {
    public static void main(String[] args) {
        ICuentaRepository cuentaRepository = new CuentaRepositoryImpl();
        Cuenta cuenta = new CuentaAhorros(123456, 100000, "Juan");
        Cuenta cuenta2 = new CuentaAhorros(123457, 100000, "Camilo");
        Cuenta cuenta3 = new CuentaAhorros(123458, 100000, "Andres");
        Cuenta cuenta4 = new CuentaCorriente(123459, 100000, "David");
        Cuenta cuenta5 = new CuentaCorriente(123460, 100000, "Jorge");
        Cuenta cuenta6 = new CuentaCorriente(123461, 100000, "Carlos");

        //-------------- GUARDAR CUENTA -----------------
        cuentaRepository.guardarCuenta(cuenta);
        cuentaRepository.guardarCuenta(cuenta2);
        cuentaRepository.guardarCuenta(cuenta3);
        cuentaRepository.guardarCuenta(cuenta4);
        cuentaRepository.guardarCuenta(cuenta5);
        cuentaRepository.guardarCuenta(cuenta6);

        //-------------- BUSCAR CUENTA -----------------
        Cuenta cuentaEncontrada = cuentaRepository.buscarCuenta(123456);
        System.out.println(cuentaEncontrada.getPropietario());
        Cuenta cuentaEncontrada2 = cuentaRepository.buscarCuenta(123457);
        System.out.println(cuentaEncontrada2.getPropietario());
        Cuenta cuentaEncontrada3 = cuentaRepository.buscarCuenta(123458);
        System.out.println(cuentaEncontrada3.getPropietario());
    }
}
