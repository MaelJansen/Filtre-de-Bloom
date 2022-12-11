package main;

import benchMark.Benchmark;
import benchMark.TauxErreur;
import benchMark.TempsExecution;
import bloom.BloomArrayList;
import bloom.BloomLinkedList;
import bloom.BloomTableau;
import bloom.Hashage;
import bloom.TypeBloom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

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
        
        benchmarkTemps(k,m);
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
}
