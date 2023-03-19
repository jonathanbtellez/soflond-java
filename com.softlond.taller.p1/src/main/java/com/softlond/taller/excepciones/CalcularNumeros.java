package com.softlond.taller.excepciones;

import java.util.ArrayList;
import java.util.List;

public class CalcularNumeros {
    public static void calcularRaizCuadrada(double num){
        double newNum;
        if(num < 0) {
            throw new ArithmeticException("Numero negativo");
        }else{
            newNum = Math.sqrt(num);
        }
        System.out.println(newNum);
    }

    public static void calcularPendienteRecta (int x1, int y1, int x2, int y2){
        int resultado = (y2 - y1)/(x2 - x1);
        System.out.println(resultado);
    }

    public static void calcularPuntoMedioRecta (int x1, int y1, int x2, int y2){
        List<Integer> resultado = new ArrayList<Integer>();
        resultado.add((x1 + x2)/2);
        resultado.add((y1 + y2)/2);
        System.out.println(resultado);
    }

    public static void raizEcuacionCuadratica(double a, double b, double c){
        double discriminante = b * b - 4 * a * c;

        if (discriminante > 0) {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Las raíces son: " + raiz1 + " y " + raiz2);
        } else if (discriminante == 0) {
            double raiz = -b / (2 * a);
            System.out.println("La raíz es: " + raiz);
        } else {
            System.out.println("La ecuación no tiene solución real.");
        }
    }

    public static String convertirBase(int numero, int base) {
        String resultado = "";

        while (numero > 0) {
            int resto = numero % base;
            resultado = Integer.toString(resto) + resultado;
            numero = numero / base;
        }

        return resultado;
    }
}
