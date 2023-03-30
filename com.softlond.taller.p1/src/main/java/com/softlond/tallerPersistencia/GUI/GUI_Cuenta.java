package com.softlond.tallerPersistencia.GUI;

import com.softlond.tallerPersistencia.models.Cuenta;
import com.softlond.tallerPersistencia.models.CuentaAhorros;
import com.softlond.tallerPersistencia.models.CuentaCorriente;
import com.softlond.tallerPersistencia.models.CuentaException;
import com.softlond.tallerPersistencia.service.CuentaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GUI_Cuenta {
    CuentaService cuentaService;
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    public GUI_Cuenta() {
        cuentaService = new CuentaService();
    }

    public void iniciar() throws CuentaException {
        System.out.println("Bienvenidos al sistema de cuentas");
        while (running) {
            System.out.println("1. Crear cuenta");
            System.out.println("2. Transferir");
            System.out.println("3. Retirar");
            System.out.println("4. Consignar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            int option = scanner.nextInt();
            seleccion(option);
        }
    }

    private void seleccion(int opcion) throws CuentaException {
        switch (opcion) {
            case 1 -> crearCuenta();
            case 2 -> tranferir();
            case 3 -> retirar();
            case 4 -> consignar();
            case 5 -> consultarSaldo();
            case 6 -> salir();
            default -> System.out.println("Opcion invalida intente de nuevo");
        }
    }

    private void crearCuenta() {
        Cuenta cuenta;
        System.out.println("Seleccione el tipo de cuenta que desea crear");
        System.out.println("1. Ahorros");
        System.out.println("2. Corriente");
        int tipoCuenta = scanner.nextInt();
        System.out.println("Ingrese el numero de cuenta");
        int numeroCuenta = scanner.nextInt();
        System.out.println("Ingrese el numero de saldo");
        int saldo = scanner.nextInt();
        System.out.println("Ingrese el nombre del propietario");
        String propietario = scanner.next();

        switch (tipoCuenta) {
            case 1 -> {
                Cuenta cuentaAux = cuentaService.buscarCuenta(numeroCuenta);
                if (cuentaAux == null) {
                    cuenta = new CuentaAhorros(numeroCuenta, saldo, propietario);
                    cuentaService.guardarCuenta(cuenta);
                    System.out.println("Cuenta de " + cuenta.getTipoCuenta() + " N: " + numeroCuenta + " creada con exito");
                } else {
                    System.out.println("Ya existe la cuenta N:" + numeroCuenta);
                }
            }
            case 2 -> {
                Cuenta cuentaAux = cuentaService.buscarCuenta(numeroCuenta);
                if (cuentaAux == null) {
                    cuenta = new CuentaCorriente(numeroCuenta, saldo, propietario);
                    cuentaService.guardarCuenta(cuenta);
                    System.out.println("Cuenta de " + cuenta.getTipoCuenta() + " N: " + numeroCuenta + " creada con exito");
                } else {
                    System.out.println("Ya existe la cuenta N:" + numeroCuenta);
                }
            }
            default -> System.out.println("Opcion invalida");
        }
    }

    private void tranferir() {
        List<Cuenta> cuentas = new ArrayList<>();
        Cuenta cuentaOrigen;
        Cuenta cuentaDestino;
        int saldo;
        System.out.println("Ingrese su numero de cuenta");
        cuentaOrigen = cuentaService.buscarCuenta(scanner.nextInt());
        if (cuentaOrigen != null) {
            System.out.println("Ingrese el numero de cuenta de destino");
            cuentaDestino = cuentaService.buscarCuenta(scanner.nextInt());
            if (cuentaDestino != null) {
                System.out.println("Ingrese el saldo a tranferir");
                saldo = scanner.nextInt();
                try {
                    cuentas = cuentaOrigen.transferir(cuentaDestino, saldo);
                } catch (CuentaException e) {
                    System.out.println("Error al transferir " + e);
                }
                for (Cuenta cuenta : cuentas) {
                    cuentaService.actualizarCuenta(cuenta);
                }
            } else {
                System.out.println("La cuenta de destino no existe");
            }
        } else {
            System.out.println("La cuenta no existe");
        }
    }

    private void retirar() {
        System.out.println("Ingrese su numero de cuenta");
        Cuenta cuenta = cuentaService.buscarCuenta(scanner.nextInt());
        System.out.println("ingrese el valor que desea retirar");
        int saldo = scanner.nextInt();
        try {
            cuenta.retirar(saldo);
            cuentaService.actualizarCuenta(cuenta);
        } catch (CuentaException e) {
            System.out.println("Error al retirar " + e);
        }
    }

    private void consignar() {
        System.out.println("Ingrese su numero de cuenta");
        Cuenta cuenta = cuentaService.buscarCuenta(scanner.nextInt());
        System.out.println("ingrese el valor que desea consignar");
        int saldo = scanner.nextInt();
        try {
            cuenta.depositar(saldo);
        } catch (CuentaException e) {
            System.out.println("Error al consignar " + e.getMessage());
        }
        cuentaService.actualizarCuenta(cuenta);
    }
    public void consultarSaldo() {
        System.out.println("Ingrese su numero de cuenta");
        Cuenta cuenta = cuentaService.buscarCuenta(scanner.nextInt());
        System.out.println("Su saldo es: " + cuenta.getSaldo());
    }

    private void salir() {
        running = false;
    }
}
