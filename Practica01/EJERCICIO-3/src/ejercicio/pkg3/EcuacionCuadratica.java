/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg3;

import java.util.Scanner;

/**
 *
 * @author pc
 */
public class EcuacionCuadratica {
    // a) Atributos privados
    private double a;
    private double b;
    private double c;
    //b) Constructor
    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //c) Cálculo del discriminante: b^2 - 4ac
    public double getDiscriminante() {
        return Math.pow(b, 2) - (4 * a * c);
    }
    //d) Metodos GET
    // Método para la primera raíz
    public double getRaiz1() {
        double disc = getDiscriminante();
        if (disc < 0) return 0;
        return (-b + Math.sqrt(disc)) / (2 * a);
    }

    // Método para la segunda raíz
    public double getRaiz2() {
        double disc = getDiscriminante();
        if (disc < 0) return 0;
        return (-b - Math.sqrt(disc)) / (2 * a);
    }
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese a: ");
        double a = input.nextDouble();
        System.out.print("Ingrese b: ");
        double b = input.nextDouble();
        System.out.print("Ingrese c: ");
        double c = input.nextDouble();

        EcuacionCuadratica ecuacion = new EcuacionCuadratica(a, b, c);
        double discriminante = ecuacion.getDiscriminante();

        if (discriminante > 0) {
            System.out.printf("La ecuación tiene dos raíces %f y %f\n", 
                ecuacion.getRaiz1(), ecuacion.getRaiz2());
        } else if (discriminante == 0) {
            System.out.printf("La ecuación tiene una raíz %.0f\n", 
                ecuacion.getRaiz1());
        } else {
            System.out.println("La ecuación no tiene raíces reales");
        }
        
        input.close();
    }
    
}
