package com.softlond.taller.p3.inmueble;

public abstract class Inmueble {
    private int IdInmobiliario;
    private int area;
    private String direccion;

    public Inmueble(int area) {
        this.area = area;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public abstract Double valorInmueble();

}
