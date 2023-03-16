package com.softlond.taller.p3;

import com.softlond.taller.p3.apartamentos.ApartaEstudio;
import com.softlond.taller.p3.apartamentos.ApartamentoFamiliar;
import com.softlond.taller.p3.casas.CasaConjunto;
import com.softlond.taller.p3.casas.CasaIndependiene;
import com.softlond.taller.p3.casas.CasaRural;
import com.softlond.taller.p3.inmueble.Inmueble;
import com.softlond.taller.p3.locales.LocalComercial;
import com.softlond.taller.p3.locales.Oficinas;

public class Main {
    public static void main(String[] args) {
        Inmueble casaRural = new CasaRural(3);
        System.out.println(casaRural.valorInmueble());

        Inmueble casaConjunto = new CasaConjunto(3);
        System.out.println(casaConjunto.valorInmueble());

        Inmueble casaIndepen = new CasaIndependiene(3);
        System.out.println(casaIndepen.valorInmueble());

        Inmueble apartaEstudio = new ApartaEstudio(3);
        System.out.println(apartaEstudio.valorInmueble());

        Inmueble apartaIndependi = new ApartamentoFamiliar(3);
        System.out.println(apartaIndependi.valorInmueble());

        Inmueble local = new LocalComercial(3);
        System.out.println(local.valorInmueble());

        Inmueble oficina = new Oficinas(3);
        System.out.println(oficina.valorInmueble());




    }
}
