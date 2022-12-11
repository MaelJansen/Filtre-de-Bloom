/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benchMark;

import bloom.BloomArrayList;
import bloom.BloomLinkedList;
import bloom.BloomTableau;
import bloom.IBloom;
import bloom.TypeBloom;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author majansen
 */
public class TauxErreur implements IBenchmark {
    
    private final TypeBloom TYPE;
    private ArrayList<Integer> valeurs;
    private final int MAX_VALEUR;
    
    public TauxErreur(TypeBloom tb, int taille, int nbValeurs, int maxValeur){
        TYPE = tb;
        MAX_VALEUR = maxValeur;
        valeurs = creerValeurs(nbValeurs);
    }
    
    // m = 1%, 5% ou 10% de nbElem
    // pour k = 1, 3 et 5
    
    public double tauxFauxPositifs(){
        IBloom filtre = remplirEnsemble();
        int nbFauxPositifs = 0;
        for (int i=0; i<MAX_VALEUR; i++){
            if (filtre.appartientAEnsemble(i) && !valeurs.contains(i)){
                nbFauxPositifs ++;
            }
        }
        if (!valeurs.isEmpty()){
            return nbFauxPositifs/valeurs.size();
        }
        return -1;
    }

    @Override
    public IBloom remplirEnsemble() {
        switch(TYPE){
            case TABLEAU :
                BloomTableau bt = new BloomTableau(valeurs.size());
                bt.remplirTableau(valeurs);
                return bt;
            case ARRAYLIST:
                BloomArrayList ba = new BloomArrayList(valeurs.size());
                ba.remplirArray(valeurs);
                return ba;
            case LINKEDLIST:
                BloomLinkedList bl = new BloomLinkedList(valeurs.size());
                bl.remplirLinkedList(valeurs);
                return bl;
            default :
                return null;
        }
    }

    /**
     * Une fonction qui créer toutes les valeurs qui seront ajouter 
     * dans les filtres (en fonction du nombre de valeurs renseigner)
     * @param nbValeurs le nombre de valeurs a ajouter
     * @return une liste contenant toutes les valeurs a utilisées
     */
    private ArrayList<Integer> creerValeurs(int nbValeurs){
        ArrayList<Integer> res = new ArrayList<>();
        Random rand = new Random();
        for (int i=0; i<nbValeurs; i++){
          int r = rand.nextInt(MAX_VALEUR);
          res.add(r);
        }
        return res;
    }
}
