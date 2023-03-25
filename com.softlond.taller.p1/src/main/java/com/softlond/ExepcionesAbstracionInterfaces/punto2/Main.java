package com.softlond.ExepcionesAbstracionInterfaces.punto2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Usted debe escribir un método que consulta las materias que tiene inscritas un estudiante,
 * a partir del código del estudiante. Si el estudiante no tiene materias inscritas, ¿debería
 * lanzar una excepción o retornar null? Explique brevemente su respuesta.
 */

/**
 * Para esta validacion decidi usar el retorno del valor null ya que
 * para este programa me permitia hacer una validacion si el valor era
 * nulo establecer el mensaje que se envia al mensaje
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> materias = new ArrayList<>();
        int controlPrograma;
        int nuevaMateria;
        String resultado;

        do{
            System.out.println("Bienvenido");
            System.out.println("Desea insertar una materia");
            System.out.println("Pulse 1 para agregar otra materia");
            System.out.println("Pulse 2 para no agregar otra materia");
            nuevaMateria = scanner.nextInt();

            while(nuevaMateria != 2) {
                System.out.println("Inserte sus materias");
                materias.add(scanner.next());
                System.out.println("Pulse 1 para agregar otra materia");
                System.out.println("Pulse 2 para no agregar otra materia");
                nuevaMateria = scanner.nextInt();
            }
            resultado = consultarMaterias(new Estudiante(materias));
            if(resultado != null){
                System.out.println("resultado = " + resultado);
            }else {
                System.out.println("resultado = No hay materias");
            }

            System.out.println("Desea asignar materias de nuevo?");
            System.out.println("Pulse 1 asignar materias de nuevo?");
            System.out.println("Pulse 2 para no asignar materias de nuevo?");
            controlPrograma = scanner.nextInt();
        }while ( controlPrograma != 2);
    }

    static String consultarMaterias(Estudiante estudiante){
        String materias;
        if(estudiante.getMaterias().size() > 0){
            materias = estudiante.getMaterias().toString();
        }else{
            materias = null;
        }
        return materias;
    }
}
