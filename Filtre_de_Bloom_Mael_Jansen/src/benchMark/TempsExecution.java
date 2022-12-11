/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benchMark;

import bloom.BloomArrayList;
import bloom.BloomLinkedList;
import bloom.BloomTableau;
import bloom.Hashage;
import bloom.IBloom;
import bloom.TypeBloom;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author majansen
 */
public class TempsExecution implements IBenchmark{
    
    private final TypeBloom TYPE;
    private final ArrayList<Integer> VALEURS;
    private final int TAILLE_ENSEMBLE;
    
    /**
     * Le constructeur pour la partie du benchmark sur le temps d'éxecition
     * @param tb le type de filtre a tester (sur quel type d'esemble)
     * @param k le nombre de fonction de hashage
     * @param m la taille du filtre
     * @param nbElem le nombre d'éléments a ajouter dans le filtre
     */
    public TempsExecution(TypeBloom tb, int k, int m,int nbElem){
        TYPE = tb;
        Hashage.initialiser(k);
        this.VALEURS = creerValeurs(nbElem);
        TAILLE_ENSEMBLE = m;
    }
    
    /**
     * Une fonctin qui permet de remplir d'appliquer le filtre dans le type
     * d'ensemble choisis
     * @return un filtre de bloom
     */
    @Override
    public IBloom remplirEnsemble(){
        switch(TYPE){
            case TABLEAU :
                BloomTableau bt = new BloomTableau(TAILLE_ENSEMBLE);
                bt.remplirTableau(VALEURS);
                return bt;
            case ARRAYLIST: 
                BloomArrayList ba = new BloomArrayList(TAILLE_ENSEMBLE);
                ba.remplirArray(VALEURS);
                return ba;
            case LINKEDLIST:
                BloomLinkedList bl = new BloomLinkedList(TAILLE_ENSEMBLE);
                bl.remplirLinkedList(VALEURS);
                return bl;
            default :
                return null;
        }
    }
    
    /**
     * Une fonction qui donne le temps d'execution en nanosecondes pour 
     * la recherche de tout les éléments ajouter dans l'ensemble choisis
     * @return le temps d'execution
     */
    public long tempsRecherche(){
        IBloom ensemble = remplirEnsemble();
        long start = System.nanoTime();
        for (Integer val : VALEURS){
             ensemble.appartientAEnsemble(val);
        }
        return System.nanoTime() - start;
    }
    
    /**
     * Une fonction qui créer toutes les valeurs qui seront ajouter 
     * dans les filtres (en fonction du nombre de valeurs renseigner)
     * @param nbValeurs le nombre de valeurs a ajouter
     * @return une liste contenant toutes les valeurs a utilisées
     */
    private ArrayList<Integer> creerValeurs(int nbValeurs){
        ArrayList<Integer> valeurs = new ArrayList<>();
        Random rand = new Random();
        for (int i=0; i<nbValeurs; i++){
          int r = rand.nextInt(1000);
          valeurs.add(r);
        }
        return valeurs;
    }
}
