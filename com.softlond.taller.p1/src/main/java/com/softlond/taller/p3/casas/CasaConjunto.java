package com.softlond.taller.p3.casas;

import java.util.List;

public class CasaConjunto extends CasaUrbana{
    private double administracion;
    private List<String> areasComunes;
    private double valorMetro = 2500000;
    public CasaConjunto(int area) {
        super(area);
    }

    @Override
    public Double valorInmueble() {
        return getArea() * valorMetro;
    }
}
