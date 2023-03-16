package com.softlond.taller.p3.apartamentos;

public class ApartaEstudio extends Apartamento{
   private static int HABITACION  = 1;
   private double valorMetro = 1500000;

   public ApartaEstudio(int area) {
      super(area);
   }

   @Override
   public Double valorInmueble() {
      return getArea() * valorMetro;
   }
}
