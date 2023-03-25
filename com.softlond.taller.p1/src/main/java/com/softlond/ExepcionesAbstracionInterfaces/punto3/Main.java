package com.softlond.ExepcionesAbstracionInterfaces.punto3;

import java.util.ArrayList;
import java.util.List;
/**
 * Se desea crear un reproductor de Música, se tienen los formatos mp3 y wav. Ambos
 * tienen como atributos la duración (minutos: segundos), tamaño, artista, compositor y
 * genero musical. Ambos se reproducen de manera diferente.
 */

/**
 *a. Para una implementación en código, ¿usaría una clase abstracta o una interfaz?
 *  ¿Por qué? Desarrolle en Java una posible solución.
 *  -------------------------SOLUCION---------------------------------
 *  Para mi solucion decidi crear una clase abstracta que me permitira tener todos los atributos que comparten Mp3 Wav
 *  y un metodo reproducir el cual sera indicado en cada clase cual debe ser su ejecucion
 */

/**
 * b. Si se decidiera agregar un formato de video en mp4, donde solo se quiere
 * reproducir su audio, y a diferencia de mp3 y wav este no posee artista, compositor
 *  y género musical, sino creador y tipo de video. ¿Implementaría clase abstracta o
 *  interfaz? ¿Por qué? ¿Como quedaría en código añadiendo el formato de video?
 *  ____________________________SOOLUCION_______________________________
 *  Cree una interface con la firma que tenia implementada en la clase abstacta
 *   lo cual me peremitiria implementar esta en la clase MusicaReproductor y la clase Mp4 que tiene unos atributos
 *   diferente pero que va a implementar el mismo metodo en el reproductor,
 *   este se acoplo muy bien al codigo y funciono de manera adecuada
 */

/**
 *  c. Si cada vez se quiere añadir un nuevo formato diferente en el reproductor, el
 *  código implementado por usted es capaz de adaptarse fácilmente. Para
 *  referencias consultar sobre escalabilidad en programación.
 *  ____________________________SOOLUCION_______________________________
 *  Personalmente creo que si ya que el metodo que tienen estos en formatos en comun
 *  es reproducir y se encuentra desacoplado permitiendo nos acoplar un nuevo formato  rapidamente
 */
public class Main {
    public static void main(String[] args) {
        List<FuncionesDispositivo> formatos = new ArrayList<>();
        FuncionesDispositivo wav = new Wav(4,35,5.5,"Iron maiden","Bruce dickenson","Metal");
        FuncionesDispositivo mp3 = new Mp3(4,35,5.5,"Nirvanaa","Kurt Cobain","Metal");
        FuncionesDispositivo mp4 = new Mp4(4,35,5.5,"Kiss","Rock");

        formatos.add(wav);
        formatos.add(mp3);
        formatos.add(mp4);

        for ( FuncionesDispositivo formato: formatos) {
            System.out.println(formato.reproducir());
        }

    }
}
