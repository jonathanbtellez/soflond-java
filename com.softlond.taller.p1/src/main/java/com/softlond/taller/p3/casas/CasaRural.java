package com.softlond.taller.p3.casas;

public class CasaRural extends Casa{
    private int distanciaCabeceraMunicipal;
    private int metrosSobreMar;
    private double valorMetro = 1500000;


    public CasaRural(int area) {
        super(area);
    }

    @Override
    public Double valorInmueble() {
        return getArea() * this.valorMetro;
    }
}
