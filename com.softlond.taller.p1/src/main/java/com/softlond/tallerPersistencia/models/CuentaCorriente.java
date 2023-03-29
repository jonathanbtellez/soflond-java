package com.softlond.tallerPersistencia.models;

public class CuentaCorriente extends Cuenta {
    private final String tipo = "corriente";
    public CuentaCorriente(int numeroCuenta, int saldo, String propietario) {

        super(numeroCuenta, saldo, propietario);
        setTipoCuenta(tipo);
    }

    @Override
    public void retirar(int saldo) throws CuentaException {
        if(this.getSaldo() >= saldo ){
            setNumeroRetiros(1);
            if(getNumeroRetiros() <= 5){
                this.setSaldo(getSaldo()-saldo);
                System.out.println("Retiro exitoso Su nuevo saldo es = " + getSaldo());
            }else{
                setNumeroRetiros(-1);
                throw new CuentaException("Numero de retiros permitidos excedido");
            }
        }else {
            throw new CuentaException("Saldo insuficiente, su saldo actual es = " + getSaldo());
        }
    }

    @Override
    public void consignar(int saldo) {
        this.setSaldo(getSaldo()+saldo);
        System.out.println("Consignacion exitosa su saldo es :" + getSaldo());
    }

    @Override
    public void transferir(int numeroCuenta, int saldo) {

    }

    @Override
    public String getTipoCuenta() {
        return tipo;
    }
}
