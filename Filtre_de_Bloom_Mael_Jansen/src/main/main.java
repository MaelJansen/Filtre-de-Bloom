package main;

import benchMark.Benchmark;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author majansen
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int k = 5;
        int m = 100;
        int nbValeurs = 100;
        
        benchmarkTemps(k,m);
        benchmarkTaux(nbValeurs);
    }
    
    public static void benchmarkTemps(int k, int m){
        int i = 0;
        System.out.println("Benchmark avec : " + k + " fonctions de hashage et " + m + " emplacements dans les ensembles");
        while (i<=500){
            System.out.println("-----------------------------");
            System.out.println("Test pour " + i + " valeurs :");
            Benchmark bm = new Benchmark(k, m, i);
            for (Map.Entry type : bm.valeursTemps.entrySet()) {
                System.out.println("temps d'execution pour " + type.getKey() + " : " + type.getValue() + " microsecondes");
            }
            i = i+50;
        } 
    }
    
    public static void benchmarkTaux(int n){
        int k = 1;
        Benchmark bm = new Benchmark(k, n , n); 
        while (k<=5){
            if (n != 0){
                switch (k){
                case 1:
                    bm = new Benchmark(k, n/100 * 1, n);
                    break;
                case 3:
                    bm = new Benchmark(k, n/100 * 5, n);
                    break;
                case 5:
                    bm = new Benchmark(k, n/100 * 10, n);
                    break;
                }
            }
            System.out.println("-------------------------------------------");
            System.out.println("Test pour " + k + " fonctions de hachages :");
            for (Map.Entry type : bm.valeursErreurs.entrySet()) {
                System.out.println("taux de faux positifs " + type.getKey() + " : " + type.getValue());
            }
            k = k+2;
        }
        
    }
}
