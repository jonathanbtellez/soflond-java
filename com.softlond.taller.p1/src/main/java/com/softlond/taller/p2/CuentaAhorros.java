package com.softlond.taller.p2;

public class CuentaAhorros extends Cuenta{
    private boolean activa = false;
    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        setSaldo(saldo);
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @Override
    public void setSaldo(float saldo) {
        super.setSaldo(saldo);
        if(super.getSaldo() >= 10000){
            setActiva(true);
        }else {
            setActiva(false);
        }
    }

    @Override
    public String consignar(float saldo) {
        String message = "";
        if(activa){
            setNumeroConsignacion(getNumeroConsignacion() + 1);
            setSaldo(getSaldo() + saldo);
            message="Consignacion realizada";
        }else {
            message="Cuenta inactiva, no se puede consignar";
        }
        return message;
    }

    @Override
    public String retirar(float saldo) {
       String message = "";
       if(activa){
           message = super.retirar(saldo);
       }else {
           message = "Cuenta inactiva, no se puede retirar";
       }
        return message;
    }

    @Override
    public void extractoMensual() {
        super.calcularInteres();
        if(getNumeroRetiros() > 3){
            setComisionMensual(getComisionMensual() + 1000);
            setSaldo(getSaldo()- getComisionMensual());
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Cuenta ahorros:");
        System.out.println("Saldo = " + getSaldo());
        System.out.println("Comision = " + getComisionMensual());
        System.out.println("Activa = "+ getActiva());
        System.out.println("Numero de transaciones = "+ (getNumeroRetiros() + getNumeroConsignacion()));
    }
}
