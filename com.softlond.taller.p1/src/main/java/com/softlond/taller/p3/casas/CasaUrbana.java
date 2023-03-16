package com.softlond.taller.p3.casas;

public abstract class CasaUrbana extends Casa{

    public CasaUrbana(int area) {
        super(area);
    }

    @Override
    public abstract Double valorInmueble();
}
