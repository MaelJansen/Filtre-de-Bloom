/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.BloomTableau to edit this template
 */
package bloom;

import java.util.ArrayList;

/**
 *
 * @author majansen
 */
public class BloomTableau implements IBloom{
    
    private boolean[] tab;
    public static int tailleTableau;
    
    public BloomTableau(int m){
        tailleTableau = m;
        tab = new boolean[m];
        initialisationBloomTableau();
    }
    
    /**
     * Une focntion qui permet de savoir si une valeur (sous forme de boolean)
     * est contenue dans le tableau
     * @param message
     * @return true si la valeur est présente false sinon
     */
    @Override
    public boolean appartientAEnsemble(int message){
        boolean trouve = true;
        for (Integer i : Hashage.tab){
            if (!tab[Hashage.Hashage(message, tailleTableau, i)]){
                trouve = false;
            }
        }
        return trouve;
    }
    
    @Override
    public void ajouterValeurBooleen(int resHashage){
        tab[resHashage] = true;
    }
    
    /**
     * Une fonction pour initialiser toutes les case du tableau 
     * du filtre de bloom a false
     */
    private void initialisationBloomTableau(){
        for(int i=0; i<tab.length; i++){
            tab[i] = false;
        }
    }
    
    /**
     *
     * @param valeurs
     */
    public void remplirTableau(ArrayList<Integer> valeurs){
        for (Integer val :  valeurs){
            for (Integer i : Hashage.tab){
                ajouterValeurBooleen(Hashage.Hashage(val, tailleTableau, i));
            }  
        }
    }
}
