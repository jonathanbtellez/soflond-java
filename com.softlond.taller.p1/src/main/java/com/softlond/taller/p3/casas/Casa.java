package com.softlond.taller.p3.casas;

import com.softlond.taller.p3.inmueble.InmuebleVivienda;

public abstract class Casa extends InmuebleVivienda {
    private int cantidadPisos;

    public Casa(int area) {
        super(area);
    }

    @Override
    public abstract Double valorInmueble();
}
