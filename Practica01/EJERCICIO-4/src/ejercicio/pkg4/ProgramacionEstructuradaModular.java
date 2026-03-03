/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg4;

import java.util.Scanner;

/**
 *
 * @author pc
 */
public class ProgramacionEstructuradaModular {

    public static double promedio(double[] datos) {
        double suma = 0;
        for (double d : datos) suma += d;
        return suma / datos.length;
    }

    public static double desviacion(double[] datos) {
        double prom = promedio(datos);
        double sumaCuadrados = 0;
        for (double d : datos) {
            sumaCuadrados += Math.pow(d - prom, 2);
        }
        return Math.sqrt(sumaCuadrados / (datos.length - 1));
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        double[] numeros = new double[10];

        System.out.println("Ingrese 10 números:");
        for (int i = 0; i < 10; i++) {
            numeros[i] = sc.nextDouble();
        }

        double prom = promedio(numeros);
        double desv = desviacion(numeros);

        System.out.printf("El promedio es %.2f%n", prom);
        System.out.printf("La desviación estándar es %.5f%n", desv);
    }
    
}
