/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloom;

import java.util.ArrayList;

/**
 *
 * @author majansen
 */
public class BloomArrayList implements IBloom {
    
    private ArrayList<Integer> array = new ArrayList<>();
    
    public BloomArrayList(int m){
        initialiserBloomArray(m);
    }
    
    private void initialiserBloomArray(int m){
        for(int i=0; i<m; i++){
            array.add(0);
        }
    }
    
    @Override
    public boolean appartientAEnsemble(int message) {
        boolean trouve = true;
        for (Integer i : Hashage.tab){
            if(array.get(Hashage.Hashage(message, array.size(), i)) != 1){
                trouve = false;
            }
        }
        return trouve;
    }

    @Override
    public void ajouterValeurBooleen(int resHashage) {
        array.remove(resHashage);
        array.add(resHashage, 1);
    }
    
    public void remplirArray(ArrayList<Integer> valeurs){
        for (Integer val : valeurs){
            for (Integer i : Hashage.tab){
                ajouterValeurBooleen(Hashage.Hashage(val, array.size(), i));
            }
        }
    }
}
