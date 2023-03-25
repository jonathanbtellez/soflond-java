package com.softlond.ExepcionesAbstracionInterfaces.punto3;

public class Mp4 implements FuncionesDispositivo{
    int minutos;
    int segundos;
    double tamanho;
    String creador;
    String tipoVideo;

    public Mp4(int minutos, int segundos, double tamanho, String creador, String tipoVideo) {
        this.minutos = minutos;
        this.segundos = segundos;
        this.tamanho = tamanho;
        this.creador = creador;
        this.tipoVideo = tipoVideo;
    }

    @Override
    public String reproducir() {
        return ("MP4 reproduciendo, Creador: "+ this.creador + " Tipo video: "+this.tipoVideo
                +" Duración "+this.minutos+":"+segundos);
    }
}
