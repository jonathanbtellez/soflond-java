package com.softlond.tallerPersistencia.models;

public class CuentaAhorros extends Cuenta {
    private final String tipo = "ahorros";
    public CuentaAhorros(int numeroCuenta, int saldo, String propietario) {
        super(numeroCuenta, saldo, propietario);
        setTipoCuenta(tipo);
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

    public String getTipoCuenta() {
        return tipo;
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

    @Override
    public void transferir(int numeroCuenta, int saldo) {

    }
}
