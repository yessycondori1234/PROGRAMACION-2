/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mipunto;

/**
 *
 * @author pc
 */
public class MiPunto {
    private double x;
    private double y;
       
     public double getX() {
        return x; 
    }
    public double getY() { 
        return y; 
    }
    // Constructor sin argumentos (0,0)
    public MiPunto() {
        this(0, 0);
    }

    // Constructor con coordenadas especificadas
    public MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }

   

    // Distancia a otro objeto MiPunto
    public double distancia(MiPunto punto) {
        return distancia(punto.getX(), punto.getY());
    }

    // Distancia a coordenadas x, y especificadas
    public double distancia(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }
    
    
    public static void main(String[] args) {
        MiPunto punto1 = new MiPunto(0, 0); 
        MiPunto punto2 = new MiPunto(10, 30.5);

        double d = punto1.distancia(punto2);

        System.out.printf("La distancia entre (0, 0) y (10, 30.5) es:%.2f%n", d);
    }
    
}
