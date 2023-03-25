package com.softlond.ExepcionesAbstracionInterfaces.punto3;
public abstract class MusicaReproductor implements FuncionesDispositivo{
    int minutos;
    int segundos;
    double tamanho;
    String artista;
    String compositor;
    String genero;

    public MusicaReproductor(int minutos, int segundos, double tamanho, String artista, String compositor, String genero) {
        this.minutos = minutos;
        this.segundos = segundos;
        this.tamanho = tamanho;
        this.artista = artista;
        this.compositor = compositor;
        this.genero = genero;
    }

    @Override
    public abstract String reproducir();

}
