package com.softlond.ExepcionesAbstracionInterfaces.punto4;

public class CuentaAhorros extends Cuenta{

    public CuentaAhorros(int numeroCuenta, int saldo, String propietario) {
        super(numeroCuenta, saldo, propietario);
    }

    @Override
    public void retirar(int saldo) throws CuentaException {
        if(this.getSaldo() >= saldo ){
            setNumeroRetiros(1);
            if(getNumeroRetiros() <= 3){
                this.setSaldo(getSaldo()-saldo);
            }else{
                this.setSaldo((int) (getSaldo()-(saldo*0.01)));
                this.setSaldo(getSaldo()-saldo);
            }
            System.out.println("Retiro exitoso Su nuevo saldo es = " + getSaldo());
        }else {
            throw new CuentaException("Saldo insuficiente, intente de nuevo");
        }
    }

    @Override
    public void consignar(int saldo) {
        this.setNumeroDepositos(1);
        if(this.getNumeroDepositos() <= 2){
            this.setSaldo((int) (this.getSaldo() + (saldo * 0.05)));
        }
        this.setSaldo(getSaldo() + saldo);
        System.out.println("Consignacion exitosa su saldo es :" + getSaldo());
    }
}
