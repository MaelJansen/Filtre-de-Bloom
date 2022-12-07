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

/**
 *
 * @author majansen
 */
public class TempsExecution {
    
    private TypeBloom type;
    private ArrayList<Integer> valeurs;
    private int tailleEnsemble;
    
    public TempsExecution(TypeBloom tb, int k, int m, ArrayList<Integer> valeurs){
        type = tb;
        Hashage.initialiser(k);
        this.valeurs = valeurs;
        tailleEnsemble = m;
    }
    
    public IBloom remplirEnsemble(){
        switch(type){
            case TABLEAU :
                BloomTableau bt = new BloomTableau(tailleEnsemble);
                bt.remplirTableau(valeurs);
                return bt;
            case ARRAYLIST: 
                BloomArrayList ba = new BloomArrayList(tailleEnsemble);
                ba.remplirArray(valeurs);
                return ba;
            case LINKEDLIST:
                BloomLinkedList bl = new BloomLinkedList(tailleEnsemble);
                bl.remplirLinkedList(valeurs);
                return bl;
            default :
                return null;
        }
    }
    
    public long tempsRecherche(){
        IBloom ensemble = remplirEnsemble();
        long start = System.nanoTime();
        for (Integer val : valeurs){
             ensemble.appartientAEnsemble(val);
        }
        return System.nanoTime() - start;
    }
}
