package com.softlond.taller.p3.locales;

import com.softlond.taller.p3.inmueble.Inmueble;

public class LocalComercial extends Inmueble {
    private String localizacion;
    private String centroComercial;
    private double valorMetro = 3000000;

    public LocalComercial(int area) {
        super(area);
    }

    @Override
    public Double valorInmueble() {
        return getArea() * valorMetro;
    }
}
