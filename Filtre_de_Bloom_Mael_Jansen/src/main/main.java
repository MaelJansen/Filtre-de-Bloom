package main;

import benchMark.TempsExecution;
import bloom.BloomArrayList;
import bloom.BloomLinkedList;
import bloom.BloomTableau;
import bloom.Hashage;
import bloom.TypeBloom;
import java.util.ArrayList;
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
        int k = 100;
        int m = 10000;
        int nbValeurs = 50;
        Hashage.initialiser(4);
        
        BloomTableau bt = new BloomTableau(m);
        BloomArrayList ba = new BloomArrayList(m);
        BloomLinkedList bl = new BloomLinkedList(m);
        
        ArrayList<Integer> valeurs = valeursTest(nbValeurs);
        
        bt.remplirTableau(valeurs);
        ba.remplirArray(valeurs);
        bl.remplirLinkedList(valeurs);
        
        TempsExecution teArray = new TempsExecution(TypeBloom.ARRAYLIST, k, 10000, valeurs);
        TempsExecution teTableau = new TempsExecution(TypeBloom.TABLEAU, k, 10000, valeurs);
        TempsExecution teLinked = new TempsExecution(TypeBloom.LINKEDLIST, k, 10000, valeurs);
        
        System.out.println("Temps pour la recherche de toutes les valeurs pour " + k + " fonction de hashage, " + m + " place dans l'ensemble de valeurs et " + nbValeurs +" valeurs) :");
        System.out.println("ArrayList : " + teArray.tempsRecherche() + " nanoseconds");
        System.out.println("Tableau : " + teTableau.tempsRecherche() + " nanoseconds");
        System.out.println("LinkedList : " + teLinked.tempsRecherche() + " nanoseconds");
        
    }
    
    public static ArrayList<Integer> valeursTest(int nb){
        ArrayList<Integer> valeurs = new ArrayList<>();
        Random rand = new Random();
        for (int i=0; i<nb; i++){
          int r = rand.nextInt(1000);
          valeurs.add(r);
        }
        return valeurs;
    }
}
