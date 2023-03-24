package com.softlond.ExepcionesAbstracionInterfaces.punto1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Usted debe escribir un método que calcula el valor que debe pagar una persona por
 * boletas de cine, lo cual depende de la cantidad de boletas que lleva. Si dentro del método
 * encuentra que la cantidad de boletas no está dentro de los rangos establecidos, ¿debería
 * lanzar una excepción o retornar cero? Explique brevemente su respuesta.
 */

/*-----------------------------------------Solucion-------------------------------------------------*/

/**
 * Para esta solucion se crea una excepcion personalizada que permite
 * lanzar el error Excepcioncine que no indica que se excede el limite maximo por persona lo cual nos permite decirle al
 * cliente que el valor de su compra es 0 ya que se intento comprar mas del numero permitido ademas se trata de manejar los
 * posibles errores que pueden ocurrir por una mala digitacion
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numeroBoletos = 0;
        int tipoPelicula = 1;
        int continuar = 0;
        int valorAPagar = 0;

        do{
            System.out.println("Bienvenido!");
            try{
                System.out.println("Cuantas boletas desea comprar?");
                numeroBoletos = scanner.nextInt();
                System.out.println("En que resolucion desea verla pelicula?");
                System.out.println("1. 2D");
                System.out.println("2. 3D");
                tipoPelicula = scanner.nextInt();
            }catch (InputMismatchException e){
                e.printStackTrace();
            }

            if(tipoPelicula < 0 || tipoPelicula >2){
                System.out.println("Tipo de pelicula incorrecto");
            }

            try {
                valorAPagar = comprarBoletas(numeroBoletos, tipoPelicula);
            } catch (Exception e){
                e.printStackTrace();
            }
            if(valorAPagar > 0){
                System.out.println("Gracias por su compra de "+numeroBoletos+" debe cancelar "+valorAPagar);
            }else{
                System.out.println("Fallo la compra numero de boletos = " +numeroBoletos+ ", maximo 5 por persona, valor a pagar "+valorAPagar);
            }
            try {
                System.out.println("Desea hacer otra compra ?");
                System.out.println("Pulsa 1 para si o 0 para no");
                continuar = scanner.nextInt();

            }catch (Exception e){
                e.printStackTrace();
            }
        }while (continuar == 1);




    }

    static int comprarBoletas(int numero, int tipoPelicula) throws ExcepcionCine {
        int resultado;

        double valorBoleta = tipoPelicula == 1 ? 5000: 10000;

        if(numero > 5){
            throw new ExcepcionCine("Excede el numero de boletas por persona");
        }else{
            numero = 0;
            resultado = (int) (numero * valorBoleta);
        }
        return resultado;
    }

}
