package com.softlond.tallerPersistencia.models;

import java.util.ArrayList;
import java.util.List;

public class CuentaCorriente extends Cuenta {
    private final String tipo = "corriente";

    public CuentaCorriente(int numeroCuenta, int saldo, String propietario) {
        super(numeroCuenta, saldo, propietario);
        setTipoCuenta(tipo);
    }

    public CuentaCorriente(int numeroCuenta, String tipoCuenta, int saldo, String propietario, int numeroDepositos, int numeroRetiros, int transferenciasOtrasCuentas) {
        super(numeroCuenta, tipoCuenta, saldo, propietario, numeroDepositos, numeroRetiros, transferenciasOtrasCuentas);
    }

    @Override
    public String getTipoCuenta() {
        return tipo;
    }

    @Override
    public void retirar(int saldo) throws CuentaException {
        if (saldo < 0) {
            throw new CuentaException("El valor a retirar debe ser mayor a 0");
        }else {
            if (this.getSaldo() >= saldo) {
                setNumeroRetiros(1);
                if (getNumeroRetiros() <= 5) {
                    this.setSaldo(getSaldo() - saldo);
                    System.out.println("Retiro exitoso Su nuevo saldo es = " + getSaldo());
                } else {
                    setNumeroRetiros(-1);
                    throw new CuentaException("Numero de retiros permitidos excedido");
                }
            } else {
                throw new CuentaException("Saldo insuficiente, su saldo actual es = " + getSaldo());
            }
        }
    }

    @Override
    public void depositar(int saldo) throws CuentaException {
        if (saldo < 0) {
            throw new CuentaException("El valor a depositar debe ser mayor a 0");
        } else {
            this.setSaldo(getSaldo() + saldo);
            System.out.println("Consignacion exitosa su saldo es :" + getSaldo());
        }
    }

    @Override
    public List<Cuenta> transferir(Cuenta cuenta, int saldo) throws CuentaException {
        if (saldo < 0) {
            throw new CuentaException("El valor a transferir debe ser mayor a 0");
        } else {
            List<Cuenta> cuentas = new ArrayList<>();

            System.out.println("transferencia a cuenta " + cuenta.getTipoCuenta());
            int interes = (int) (saldo * 0.02);
            if (this.getSaldo() >= (saldo + interes)) {
                if (cuenta.getTipoCuenta().equals("ahorros")) {
                    this.setTransferenciasOtrasCuentas(1);
                    System.out.println("Numero de transferencias a cuentas de ahorro realizadas: " + getTransferenciasOtrasCuentas());
                    if (this.getTransferenciasOtrasCuentas() > 2) {
                        throw new CuentaException("Numero maximo de transferencias a cuentas de ahorro ya realizadas");
                    } else {
                        System.out.println("Cuenta saldo inicial: " + this.getSaldo());
                        this.setSaldo((this.getSaldo() - saldo) - interes);
                        System.out.println("Transferencia exitosa su saldo despues de la transferencia es :" + this.getSaldo());
                        cuenta.recibir(saldo);
                        System.out.println("La cuenta:" + cuenta.getNumeroCuenta() + " recibio una transferencia de " + saldo);
                    }
                } else {
                    System.out.println("Cuenta saldo inicial: " + this.getSaldo());
                    this.setSaldo(this.getSaldo() - (saldo - interes));
                    System.out.println("Transferencia exitosa su saldo despues de la transferencia es :" + this.getSaldo());
                    cuenta.recibir(saldo);
                    System.out.println("La cuenta:" + cuenta.getNumeroCuenta() + " recibio una transferencia de " + saldo);
                }
                cuentas.add(this);
                cuentas.add(cuenta);
            } else {
                System.out.println("Saldo insuficiente");
            }
            return cuentas;
        }
    }

    @Override
    public void recibir(int saldo) {
        if (saldo < 0){
            throw new RuntimeException("El valor a recibir debe ser mayor a 0");
        } else {
            this.setSaldo(this.getSaldo() + saldo);
        }
    }
}
