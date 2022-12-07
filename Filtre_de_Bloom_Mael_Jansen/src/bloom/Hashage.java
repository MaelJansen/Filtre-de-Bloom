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
public final class Hashage {
    
    public static ArrayList<Integer> tab = new ArrayList<>();
    
    public static void initialiser(int k){
        int index = 0;
        int i = 2;
        while (index<k){
            if (estPremier(i)){
                tab.add(i);
                index ++;
            }
            i++;
        }
    }
    
    /**
     * La première fonction de hashage
     * @param valeur la valeur a hasher
     * @param m la taille du tableau
     * @return le resultat du hashage
     */
    public static int Hashage(int valeur, int m, int premier){
        return (valeur * premier + premier) % m; 
    }
    
    public static boolean estPremier(int n){
        int reste;
        boolean estPremier = true;
        for (int i=2; i<n; i++){
            reste = n%i;
            if (reste == 0){
                estPremier = false;
                break;
            }
        }
        return estPremier;
    }
}
