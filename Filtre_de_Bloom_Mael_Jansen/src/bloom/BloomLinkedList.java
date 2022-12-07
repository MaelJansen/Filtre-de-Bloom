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
    
    private LinkedList<Integer> linkedList = new LinkedList<>();
    
    public BloomLinkedList(int m){
        initialiserBloomLinkedList(m);
    }
    
    private void initialiserBloomLinkedList(int m){
        for(int i=0; i<m; i++){
            linkedList.add(0);
        }
    }

    @Override
    public boolean appartientAEnsemble(int message) {
        boolean trouve = true;
        for (Integer i : Hashage.tab){
            if(linkedList.get(Hashage.Hashage(message, linkedList.size(), i)) != 1){
                trouve = false;
            }
        }
        return trouve;
    }

    @Override
    public void ajouterValeurBooleen(int resHashage) {
        linkedList.remove(resHashage);
        linkedList.add(resHashage, 1);
    }
    
    public void remplirLinkedList(ArrayList<Integer> valeurs){
        for (Integer val : valeurs){
            for (Integer i : Hashage.tab){
                ajouterValeurBooleen(Hashage.Hashage(val, linkedList.size(), i));
            }
        }
    }
}
