/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozproszone_lab9;

/**
 *
 * @author Damian Darczuk
 */
public class Rozproszone_Lab9 {

    
    public static void main(String[] args) throws InterruptedException {
        Magazyn magazyn = new Magazyn();
        Konsument konsumenci[] = new Konsument[20];
        Producent producenci[] = new Producent[20];
        
        for(int i =0; i< 20; i++){
            konsumenci[i] = new Konsument(magazyn, i);
            konsumenci[i].start();
            producenci[i] = new Producent(magazyn, i);
            producenci[i].start();
        }
              
        
     //   for(int i =0; i< 20; i++){
     //       producenci[i].join();
     //       konsumenci[i].join();
     //   }
        
        
    }
    
}
