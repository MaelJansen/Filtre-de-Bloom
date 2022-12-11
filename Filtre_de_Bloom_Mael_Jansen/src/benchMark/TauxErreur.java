/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benchMark;

import bloom.TypeBloom;
import static java.lang.Math.exp;
import static java.lang.Math.pow;
import java.util.ArrayList;

/**
 *
 * @author majansen
 */
public class TauxErreur {
    
    private final TypeBloom TYPE;
    private ArrayList<Integer> tailles = new ArrayList<>();
    
    public TauxErreur(TypeBloom tb, int k, int nbElem){
        TYPE = tb;
        calculTailles(nbElem);
        
    }
    
    // m = 1%, 5% ou 10% de nbElem
    // pour k = 1, 3 et 5
    
    /**
     * Une fonction qui permet de determiner les tailles de filtre 
     * dont on va avoir besoin pour le benchmark 
     * (1%, 5% et 10% du nombre de valeurs)
     * @param nbValeurs le nombre de valeurs que l'on va utiliser
     */
    private void calculTailles(int nbValeurs){
        tailles.add((nbValeurs/100) * 10);
        tailles.add((nbValeurs/100) * 5);
        tailles.add((nbValeurs/100) * 1);
    }
    
    public double tauxFauxPositifs(int m, int k, int nbValeurs){
        return pow(1-exp((-k*nbValeurs)/m),k);
    }
}
