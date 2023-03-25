package com.softlond.ExepcionesAbstracionInterfaces.punto4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cuenta cuenta =new CuentaAhorros(1,10000,"jonathan");
        Cuenta cuentaCorriente = new CuentaCorriente(1,10000,"jonathan");
        Cuenta cuentaPrograma;
        String mensaje;
        int controlPrograma;

        do {
            System.out.println("Bienvenido!");
            System.out.println("pulse 1 si desea usar la cuenta de ahorros");
            System.out.println("pulse 2 si desea usar la cuenta corriente");
            controlPrograma = scanner.nextInt();

            cuentaPrograma = controlPrograma == 1 ? cuenta : cuentaCorriente;

            System.out.println("pulse 1 si desea retirar");
            System.out.println("pulse 2 si desea depositar");
            controlPrograma = scanner.nextInt();

            mensaje = controlPrograma == 1 ? "retirar":"depositar";

            System.out.println("Inserte el valor que desea "+ mensaje);
            if (controlPrograma == 1){
                try {
                    cuentaPrograma.retirar(scanner.nextInt());
                }catch (CuentaException cuentaException){
                    cuentaException.printStackTrace();
                }
            }else {
                cuentaPrograma.consignar(scanner.nextInt());
            }

            System.out.println("Desea hacer otra transaccion?");
            System.out.println("pulse 1 si desea realizar otra transaccion");
            System.out.println("pulse 2 si no desea realizar otra transaccion");
            controlPrograma = scanner.nextInt();
        }while (controlPrograma != 2);
    }
}
