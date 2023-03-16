package com.softlond.taller.p3.apartamentos;

public class ApartamentoFamiliar extends Apartamento{
    private double administracion;
    private double valorMetro = 2000000;
    public ApartamentoFamiliar(int area) {
        super(area);
    }

    @Override
    public Double valorInmueble() {
        return getArea() * valorMetro;
    }
}
