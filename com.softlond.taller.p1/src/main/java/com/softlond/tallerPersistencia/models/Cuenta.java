package com.softlond.tallerPersistencia.models;

/**
 * Se requiere crear un Software para un banco, este maneja diferentes tipos de cuentas,
 * Ahorro y Corriente, tienen como atributos el numero de cuenta, saldo, y un propietario. Se
 * pueden realizar acciones como depositar y retirar. Al momento de retirar dinero, en la
 * cuenta de ahorros, deberá restar el monto solicitado, y si realiza más de 3 retiros, deberá
 * de restar un 1% del valor que retira, es decir si pide retirar un valor de 3000 unidades debe
 * sacar un 1% que son 30 unidades, y restar un total de 3030 unidades si se cumple que se
 * hacen más de 3 retiros. Para una cuenta corriente, no debe permitir realizar más de 5
 * retiros, además, al depositar en una cuenta de ahorros, se adicionará un 0.5% del valor
 * depositado en el saldo para sus 2 primeros depósitos. Implemente una solución en Java,
 * con clases abstractas o interfaces, y realice las validaciones correspondientes con el uso de
 * excepciones propias.
 */
public abstract class Cuenta {
    private int numeroCuenta;
    private String tipoCuenta;
    private int saldo;
    private String propietario;
    private int numeroDepositos;
    private int numeroRetiros;

    public Cuenta(int numeroCuenta, int saldo, String propietario) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.propietario = propietario;
    }

    public abstract void retirar(int saldo) throws CuentaException;
    public abstract void consignar(int saldo);
    public abstract void transferir(int numeroCuenta, int saldo);
    public abstract String getTipoCuenta();

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getNumeroDepositos() {
        return numeroDepositos;
    }

    public void setNumeroDepositos(int numeroDepositos) {
        this.numeroDepositos += numeroDepositos;
    }

    public int getNumeroRetiros() {
        return numeroRetiros;
    }

    public void setNumeroRetiros(int numeroRetiros) {
        this.numeroRetiros += numeroRetiros;
    }
}
