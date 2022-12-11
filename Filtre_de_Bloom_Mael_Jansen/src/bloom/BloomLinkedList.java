/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloom;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author majansen
 */
public class BloomLinkedList implements IBloom{
    
    private final LinkedList<Integer> LINKEDLIST = new LinkedList<>();
    
    public BloomLinkedList(int m){
        initialiserBloomLinkedList(m);
    }
    
    private void initialiserBloomLinkedList(int m){
        for(int i=0; i<m; i++){
            LINKEDLIST.add(0);
        }
    }

    @Override
    public boolean appartientAEnsemble(int message) {
        boolean trouve = true;
        for (Integer i : Hashage.tab){
            if(LINKEDLIST.get(Hashage.Hashage(message, LINKEDLIST.size(), i)) != 1){
                trouve = false;
            }
        }
        return trouve;
    }

    @Override
    public void ajouterValeurBooleen(int resHashage) {
        LINKEDLIST.remove(resHashage);
        LINKEDLIST.add(resHashage, 1);
    }
    
    public void remplirLinkedList(ArrayList<Integer> valeurs){
        for (Integer val : valeurs){
            for (Integer i : Hashage.tab){
                ajouterValeurBooleen(Hashage.Hashage(val, LINKEDLIST.size(), i));
            }
        }
    }
}
