package com.softlond.ExepcionesAbstracionInterfaces.punto3;

public class Wav extends MusicaReproductor{
    public Wav(int minutos, int segundos, double tamanho, String artista, String compositor, String genero) {
        super(minutos, segundos, tamanho, artista, compositor, genero);
    }

    @Override
    public String reproducir() {
        return ("Wav reproduciendo Artista: "+ this.artista + " Compositor: "+this.compositor + " Genero:"+this.genero
                +" Duración "+this.minutos+":"+segundos);
    }
}
