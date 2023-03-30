package com.softlond.tallerPersistencia.models;

import java.util.ArrayList;
import java.util.List;

public class CuentaAhorros extends Cuenta {
    private final String tipo = "ahorros";
    public CuentaAhorros(int numeroCuenta, int saldo, String propietario) {
        super(numeroCuenta, saldo, propietario);
        setTipoCuenta(tipo);
    }
    public CuentaAhorros(int numeroCuenta, String tipoCuenta, int saldo, String propietario, int numeroDepositos, int numeroRetiros, int transferenciasOtrasCuentas) {
        super(numeroCuenta, tipoCuenta, saldo, propietario, numeroDepositos, numeroRetiros, transferenciasOtrasCuentas);
    }

    public String getTipoCuenta() {
        return tipo;
    }
    @Override
    public int retirar(int saldo) throws CuentaException {
        int saldoRetirado;
        if(this.getSaldo() >= saldo ){
            setNumeroRetiros(1);
            if(getNumeroRetiros() <= 3){
                this.setSaldo(getSaldo()-saldo);
            }else{
                this.setSaldo((int) (getSaldo()-(saldo*0.01)));
                this.setSaldo(getSaldo()-saldo);
            }
            System.out.println("Retiro exitoso Su nuevo saldo es = " + getSaldo());
            saldoRetirado = saldo;
        }else {
            throw new CuentaException("Saldo insuficiente, intente de nuevo");
        }
        return saldoRetirado;
    }

    @Override
    public int depositar(int saldo) {
        int saldoConsignado;
        int cashBack = (int) (saldo * 0.05);
        this.setNumeroDepositos(1);
        if(this.getNumeroDepositos() <= 2){
            this.setSaldo(getSaldo() + saldo + cashBack);
            saldoConsignado = saldo + cashBack;
        }else {
            this.setSaldo(getSaldo() + saldo);
            saldoConsignado = saldo;
        }
        System.out.println("Consignacion exitosa por: "+saldoConsignado);
        return saldoConsignado;
    }

    @Override
    public List<Cuenta> transferir(Cuenta cuenta, int saldo) {
        List<Cuenta> cuentas = new ArrayList<>();
        int interes = (int) (saldo*0.015);

        if(cuenta.getSaldo() >= saldo){
            if(this.getTipoCuenta().equals(cuenta.getTipoCuenta())){
                System.out.println("Saldo antes de la transferencia: "+this.getSaldo());
                this.setSaldo(this.getSaldo() - saldo);
                System.out.println("Transferencia exitosa su saldo es :" + this.getSaldo());
                cuenta.recibir(cuenta.getSaldo() + saldo);
                System.out.println("La cuenta destino recibio: "+saldo);
            }else{
                System.out.println("Saldo antes de la transferencia: "+this.getSaldo());
                this.setSaldo((this.getSaldo() - saldo)- interes);
                System.out.println("Transferencia exitosa su saldo es :" + this.getSaldo());
                cuenta.recibir(this.getSaldo() + saldo);
                System.out.println("La cuenta destino recibio: "+saldo);
            }
        }else{
            System.out.println("Saldo insuficiente");
        }
        cuentas.add(this);
        cuentas.add(cuenta);
        return cuentas;
    }

    @Override
    public void recibir(int saldo) {
        this.setSaldo(getSaldo() + saldo);
    }
}
