package com.softlond.taller.p3.apartamentos;

import com.softlond.taller.p3.inmueble.InmuebleVivienda;

public abstract class Apartamento extends InmuebleVivienda {
    public Apartamento(int area) {
        super(area);
    }

    @Override
    public abstract Double valorInmueble();
}
