package com.softlond.taller.p3.locales;

import com.softlond.taller.p3.inmueble.Inmueble;

public class Oficinas extends Inmueble {
    private boolean esGubernamental;
    private double valorMetro = 3500000;
    public Oficinas(int area) {
        super(area);
    }

    @Override
    public Double valorInmueble() {
        return getArea() * valorMetro;
    }
}
