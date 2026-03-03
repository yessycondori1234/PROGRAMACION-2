/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg1;

import java.util.Random;

/**
 *
 * @author pc
 */
public class Cronometro {
 // a) Atributos privados con getters
    private int inicia;
    private int finaliza;

    public int getInicia() {
        return inicia;
    }

    public int getFinaliza() {
        return finaliza;
    }
    
    
    // b) Constructor que inicializa con la hora actual
    public Cronometro() {
        this.inicia = (int) System.currentTimeMillis();
    }
    
   // c) Restablece inicia a la hora actual
    public void inicia() {
        this.inicia = (int) System.currentTimeMillis();
    }

    // d) Establece finaliza a la hora actual
    public void detener() {
        this.finaliza = (int) System.currentTimeMillis();
    }
     // Retorna el tiempo transcurrido en milisegundos
    public long lapsoDeTiempo() {
        return finaliza - inicia;
    }
    
    
    public static void main(String[] args) {
        Cronometro crono = new Cronometro();
        crono.inicia();
   
        Random rnd = new Random();
        int min = 1;
        int max = 100000;
      
        int[] numeros = new int[max];
        // Llenar arreglo con números aleatorios
        for (int i = 0; i < max; i++) {
            numeros[i] = rnd.nextInt((max - min)+1)+min;
        }
        for(int i=0; i <= 100; i++){
            System.out.println(numeros[i]);
        }
       
        //mover el limite del subarray ordenado uno por uno
         for (int i = 0; i < numeros.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[j] < numeros[minIdx]) {
                    minIdx = j;
                }
            }
        //Intercambiar el minimo encontrado con el primer elemento
         int temp = numeros[minIdx];
            numeros[minIdx] = numeros[i];
            numeros[i] = temp;
        
         }
        
        System.out.println("despues");
        for(int i=0; i <= 100; i++){
            System.out.println(numeros[i]);
        }
        
        crono.detener();
        System.out.println("Lapso de Tiempo: " + crono.lapsoDeTiempo() + " milisegundos");
        
     
    
        }
    
}
