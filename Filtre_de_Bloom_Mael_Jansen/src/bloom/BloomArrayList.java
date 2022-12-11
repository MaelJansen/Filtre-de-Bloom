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
    
    private final ArrayList<Integer> ARRAY = new ArrayList<>();
    
    public BloomArrayList(int m){
        initialiserBloomArray(m);
    }
    
    private void initialiserBloomArray(int m){
        for(int i=0; i<m; i++){
            ARRAY.add(0);
        }
    }
    
    @Override
    public boolean appartientAEnsemble(int message) {
        boolean trouve = true;
        for (Integer i : Hashage.tab){
            if(ARRAY.get(Hashage.Hashage(message, ARRAY.size(), i)) != 1){
                trouve = false;
            }
        }
        return trouve;
    }

    @Override
    public void ajouterValeurBooleen(int resHashage) {
        ARRAY.remove(resHashage);
        ARRAY.add(resHashage, 1);
    }
    
    public void remplirArray(ArrayList<Integer> valeurs){
        for (Integer val : valeurs){
            for (Integer i : Hashage.tab){
                ajouterValeurBooleen(Hashage.Hashage(val, ARRAY.size(), i));
            }
        }
    }
}
