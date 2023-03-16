package com.softlond.taller.p2;

public class Main {
    public static void main(String[] args) {
        Cuenta cuenta = new CuentaAhorros(12000,12);
        //Consignaciones
        System.out.println("Consignaciones");
        System.out.println(cuenta.consignar(300));
        System.out.println(("Saldo = " + cuenta.getSaldo()).concat(" numero de consignacion = "+cuenta.getNumeroConsignacion()));
        System.out.println(cuenta.consignar(300));
        System.out.println(("Saldo = " + cuenta.getSaldo()).concat(" numero de consignacion = "+cuenta.getNumeroConsignacion()));
        System.out.println();

        // retiros
        System.out.println("Retiros");
        System.out.println(cuenta.retirar(100));
        System.out.println(("Saldo = " + cuenta.getSaldo()).concat(" numero de retiro = "+cuenta.getNumeroRetiros()));
        System.out.println(cuenta.retirar(100));
        System.out.println(("Saldo = " + cuenta.getSaldo()).concat(" numero de retiro = "+cuenta.getNumeroRetiros()));
        System.out.println(cuenta.retirar(100));
        System.out.println(("Saldo = " + cuenta.getSaldo()).concat(" numero de retiro = "+cuenta.getNumeroRetiros()));
        System.out.println(cuenta.retirar(2300));
        System.out.println(("Saldo = " + cuenta.getSaldo()).concat(" numero de retiro = "+cuenta.getNumeroRetiros()));
        System.out.println();

        //Extracto
        System.out.println("Extracto");
        cuenta.extractoMensual();
        System.out.println("La comimsion mesual es = " + cuenta.getComisionMensual());
        System.out.println("Su numero de retiros es = "+ cuenta.getNumeroRetiros()+", Su saldo luego del extrato es = " + cuenta.getSaldo());
        System.out.println();

        //Imprimir
        System.out.println("Imprimir");
        cuenta.imprimir();

        System.out.println();
        System.out.println("Cuenta Corriente");
        Cuenta cuenta1 = new CuentaCorriente(9000,12);

        System.out.println();
        System.out.println(cuenta1.retirar(10000));

        System.out.println();
        System.out.println(cuenta1.consignar(700));
        System.out.println(cuenta1.consignar(700));

        System.out.println();
        cuenta1.extractoMensual();
        System.out.println("La comimsion mesual es = " + cuenta1.getComisionMensual());
        System.out.println("Su numero de retiros es = "+ cuenta1.getNumeroRetiros()+", Su saldo luego del extrato es = " + cuenta1.getSaldo());

        System.out.println();
        cuenta1.imprimir();




    }
}
