package com.softlond.taller.p2;

public class CuentaCorriente extends Cuenta{
    private float sobreGiro = 0;
    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    public float getSobreGiro() {
        return sobreGiro;
    }
    public void setSobreGiro(float sobreGiro) {
        this.sobreGiro = sobreGiro;
    }
    @Override
    public String retirar(float saldo) {
        String message = "";
        if(getSaldo() - saldo < 0){
            setSobreGiro(saldo - (getSaldo()) + getSobreGiro());
            message = "Se realizo el retiro exitosamente, tiene es su cuenta un sobregiro por: " +getSobreGiro();
        }else{
            setNumeroRetiros(getNumeroRetiros() + 1);
            setSaldo(getSaldo() - saldo);
            message="Retiro realizado correctamente";
        }
        return message;
    }
    @Override
    public String consignar(float saldo) {
        String message = "";
        if(getSobreGiro() > 0){
            if(getSobreGiro() > saldo){
                setNumeroConsignacion(getNumeroConsignacion() +1);
            }
            setSobreGiro(getSobreGiro() - saldo);
            message = "Consignacion realizado tiene un sobregiro de = " + getSobreGiro();
            if(getSobreGiro() < 0) {
                message = super.consignar(getSobreGiro());
                setSobreGiro(0);
            }
        }else {
            message = super.consignar(saldo);
        }
        return message;
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
        setSaldo(getSaldo()-getComisionMensual());
    }

    @Override
    public void imprimir() {
        System.out.println("Cuenta corriemte:");
        System.out.println("Saldo = " + getSaldo());
        System.out.println("Comision = " + getComisionMensual());
        System.out.println("Numero de transaciones = "+ (getNumeroRetiros() + getNumeroConsignacion()));
        System.out.println("Sobre giro = " + sobreGiro);
    }
}
