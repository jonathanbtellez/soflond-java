package com.softlond.ExepcionesAbstracionInterfaces.punto3;

public class Mp3 extends MusicaReproductor{
    public Mp3(int minutos, int segundos, double tamanho, String artista, String compositor, String genero) {
        super(minutos, segundos, tamanho, artista, compositor, genero);
    }

    @Override
    public String reproducir() {
        return ("MP3 reproduciendo Artista: "+ this.artista + " Compositor: "+this.compositor + " Genero:"+this.genero
                +" Duración "+this.minutos+":"+segundos);
    }
}
