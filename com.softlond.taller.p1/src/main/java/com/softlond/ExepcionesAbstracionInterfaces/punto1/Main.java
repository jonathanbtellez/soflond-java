package com.softlond.ExepcionesAbstracionInterfaces.punto1;
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
            System.out.println("Cuantas boletas desea comprar?");
            numeroBoletos = scanner.nextInt();
            System.out.println("En que resolucion desea verla pelicula?");
            System.out.println("1. 2D");
            System.out.println("2. 3D");
            tipoPelicula = scanner.nextInt();

            if(tipoPelicula < 1 || tipoPelicula > 2){
                System.out.println("Tipo de pelicula incorrecto");
            }else {
                try {
                    valorAPagar = comprarBoletas(numeroBoletos, tipoPelicula);
                } catch (ExcepcionCine e){
                    e.printStackTrace();
                }
            }
            if(valorAPagar > 0){
                String resolucion = tipoPelicula == 1 ? "2D" : "3D";
                System.out.println("Gracias por su compra de "+numeroBoletos+" boletas en "+ resolucion+" cancelar "+valorAPagar);
            }else{
                System.out.println("Fallo la compra numero de boletos = " +numeroBoletos+ ", maximo 5 por persona, valor a pagar "+valorAPagar);
            }
            System.out.println("Desea hacer otra compra ?");
            System.out.println("Pulsa 1 para si o 0 para no");
            continuar = scanner.nextInt();
        }while (continuar == 1);
    }
    static int comprarBoletas(int numero, int tipoPelicula) throws ExcepcionCine {
        int resultado ;
        double valorBoleta = tipoPelicula == 1 ? 5000: 10000;

        if(numero  > 0 && numero < 6){
            resultado = (int) (numero * valorBoleta);
        }else{
            throw new ExcepcionCine("Excede el numero de boletas por persona");
        }
        return resultado;
    }

}
