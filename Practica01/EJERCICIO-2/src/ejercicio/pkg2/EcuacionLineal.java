package ejercicio.pkg2;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class EcuacionLineal {
    // a) Atributos privados
    private double a, b, c, d, e, f;
    // b) Constructor
    public EcuacionLineal(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c; 
        this.d = d;
        this.e = e;
        this.f = f;
    }
    // c) Método para verificar si el determinante es distinto de cero
    public boolean tieneSolucion() {
        return (a * d - b * c) != 0;
    }
    //d) Metodos GET
    // Método para obtener x: (ed - bf) / (ad - bc)
    public double getX() {
        return (e * d - b * f) / (a * d - b * c);
    }

    // Método para obtener y: (af - ec) / (ad - bc)
    public double getY() {
        return (a * f - e * c) / (a * d - b * c);
    }
    
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);

        System.out.print("Ingrese a:");
        double a = input.nextDouble();
         System.out.print("Ingrese b:");
        double b = input.nextDouble();
         System.out.print("Ingrese c:");
        double c = input.nextDouble();
         System.out.print("Ingrese d:");
        double d = input.nextDouble();
         System.out.print("Ingrese e:");
        double e = input.nextDouble();
         System.out.print("Ingrese f:");
        double f = input.nextDouble();
        

        EcuacionLineal ecuacion = new EcuacionLineal(a, b, c, d, e, f);

        if (ecuacion.tieneSolucion()) {
            System.out.printf("x = %.1f, y = %.1f\n", ecuacion.getX(), ecuacion.getY());
        } else {
            System.out.println("La ecuación no tiene solución");
        }
        
        input.close();
    }
    
    
}
