package com.softlond.taller.p3.inmueble;

public abstract class InmuebleVivienda extends Inmueble{
    int numeroBanhos;
    int numeroHabitaciones;

    public InmuebleVivienda(int area) {
        super(area);
    }

    @Override
    public abstract Double valorInmueble();
}
