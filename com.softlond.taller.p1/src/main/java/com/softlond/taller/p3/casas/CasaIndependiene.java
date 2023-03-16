package com.softlond.taller.p3.casas;

public class CasaIndependiene extends CasaUrbana{
    private double valorMetro = 3000000;
    public CasaIndependiene(int area) {
        super(area);
    }

    @Override
    public Double valorInmueble() {
        return getArea() * valorMetro;
    }
}
