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
public class Estadisticas {
   //SOLUCION PROGRAMACION ORIENTADA A OBJETOS
     // Atributo encapsulado
    private double[] datos;

    // Constructor
    public Estadisticas(double[] datos) {
        this.datos = datos;
    }

    // Método para obtener el promedio
    public double promedio() {
        double suma = 0;
        for (double d : this.datos) {
            suma += d;
        }
        return suma / this.datos.length;
    }

    // Método para obtener la desviación estándar
    public double desviacion() {
        double prom = this.promedio();
        double sumaCuadrados = 0;
        for (double d : this.datos) {
            sumaCuadrados += Math.pow(d - prom, 2);
        }
        return Math.sqrt(sumaCuadrados / (this.datos.length - 1));
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        double[] valores = new double[10];

        System.out.println("Ingrese 10 números :");
        for (int i = 0; i < 10; i++) {
            int x=i+1;
            System.out.println("Número "+ x +":");
            valores[i] = sc.nextDouble();
        }

        // Creación del objeto (Instanciación)
        Estadisticas calc = new Estadisticas(valores);

        // Llamada a los métodos del objeto
        System.out.printf("El promedio es %.2f%n", calc.promedio());
        System.out.printf("La desviación estándar es %.5f%n", calc.desviacion());
    }
    
}
