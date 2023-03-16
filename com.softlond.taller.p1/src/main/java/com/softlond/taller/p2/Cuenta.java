package com.softlond.taller.p2;

public abstract class Cuenta {
    private float saldo;
    private int numeroConsignacion = 0;
    private int numeroRetiros = 0;
    private float tasaAnual;
    private float ComisionMensual = 0;
    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }


    public float getComisionMensual() {
        return ComisionMensual;
    }

    public void setComisionMensual(float comisionMensual) {
        ComisionMensual = comisionMensual;
    }

    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public int getNumeroConsignacion() {
        return numeroConsignacion;
    }
    public int getNumeroRetiros() {
        return numeroRetiros;
    }

    public void setNumeroRetiros(int numeroRetiros) {
        this.numeroRetiros = numeroRetiros;
    }
    public void setNumeroConsignacion(int numeroConsignacion) {
        this.numeroConsignacion = numeroConsignacion;
    }
    public String consignar(float saldo){
        String message = "";
        setNumeroConsignacion(getNumeroConsignacion() + 1);
        setSaldo(getSaldo() + saldo);
        return message="Consignacion realizada";
    };
    public String retirar(float saldo){
        String message = "";
        if(getSaldo() - saldo > 0){
            setNumeroRetiros(getNumeroRetiros() + 1);
            setSaldo(getSaldo() - saldo);
            message = "Retiro realizado correctamente";
        }else {
            message = "Saldo insuficiente";
        }
        return message;
    };
    public void calcularInteres(){
        setComisionMensual(getTasaAnual() / 12);
        setComisionMensual((getSaldo() * getComisionMensual()/100));
    }

    public void extractoMensual(){
        calcularInteres();
    }
    
    public void imprimir(){
        System.out.println("Cuenta:");
        System.out.println("Saldo = " + getSaldo());
        System.out.println("TasaAnual = " + getTasaAnual());
        System.out.println("Comision = " + getComisionMensual());
        System.out.println("Numero de retiros = " + getNumeroRetiros());
        System.out.println("Numero de consignacion = " + getNumeroConsignacion());
    }
}
