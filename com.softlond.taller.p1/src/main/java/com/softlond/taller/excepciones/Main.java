package com.softlond.taller.excepciones;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero del cual desea saber la raiz cuadrada");
        double num = scanner.nextDouble();
        CalcularNumeros.calcularRaizCuadrada(num);


        try{
            System.out.println("Ingrese la posicion 1 de punto A");
            int x1 = scanner.nextInt();

            System.out.println("Ingrese la posicion 2 de punto A");
            int y1 = scanner.nextInt();

            System.out.println("Ingrese la posicion 1 de punto B");
            int x2 = scanner.nextInt();

            System.out.println("Ingrese la posicion 2 de punto B");
            int y2 = scanner.nextInt();

            CalcularNumeros.calcularPendienteRecta(x1,y1,x2,y2);
            CalcularNumeros.calcularPuntoMedioRecta(x1,y1,x2,y2);
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            System.out.println("Ingrese el valor de a:");
            double a = scanner.nextDouble();

            System.out.println("Ingrese el valor de b:");
            double b = scanner.nextDouble();

            System.out.println("Ingrese el valor de c:");
            double c = scanner.nextDouble();

            CalcularNumeros.raizEcuacionCuadratica( a, b, c);
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            System.out.println("Ingrese un número en base 10:");
            int numero = scanner.nextInt();

            System.out.println("Ingrese la base a la que desea convertir el número:");
            int base = scanner.nextInt();

            String numeroConvertido = CalcularNumeros.convertirBase(numero, base);

            System.out.println("El número " + numero + " en base " + base + " es: " + numeroConvertido);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
