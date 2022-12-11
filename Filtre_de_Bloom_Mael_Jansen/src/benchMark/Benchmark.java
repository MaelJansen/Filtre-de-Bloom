/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benchMark;

import bloom.TypeBloom;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author majansen
 */
public class Benchmark {
    
    private TempsExecution temps;
    public HashMap<TypeBloom, Long> valeursTemps = new HashMap<>();
    private TauxErreur taux;
    public HashMap<TypeBloom, Double> valeursErreurs = new HashMap<>();
    private ArrayList<TypeBloom> types = new ArrayList<>();
    private int k;
    private int taille; 
    private int nbValeurs;
    
    /**
     * 
     * @param k le nombre de fonction de hashage que l'on veut utiliser
     * @param taille la taille de l'ensemble resusltat
     * @param nbValeurs le nombre de valeurs que l'on utiliser
     */
    public Benchmark(int k, int taille, int nbValeurs){
        this.k = k;
        this.taille = taille;
        this.nbValeurs = nbValeurs;
        ajouterTypes();
        calculerTemps();
        calculerTauxFauxPositifs();
    }
    
    private void calculerTemps(){
        for (TypeBloom t : types){
            temps = new TempsExecution(t, k, taille, nbValeurs);
            if (!valeursTemps.containsKey(t)){
                valeursTemps.put(t, temps.tempsRecherche()/1000);
            }
        }
    }
    
    private void calculerTauxFauxPositifs(){
        for (TypeBloom t : types){
            taux = new TauxErreur(t, taille, nbValeurs, 1000);
            if (!valeursErreurs.containsKey(t)){
                valeursErreurs.put(t, taux.tauxFauxPositifs());
            }
        }
    }
    
    private void ajouterTypes(){
        types.add(TypeBloom.ARRAYLIST);
        types.add(TypeBloom.LINKEDLIST);
        types.add(TypeBloom.TABLEAU);
    }
}
