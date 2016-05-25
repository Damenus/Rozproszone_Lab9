/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozproszone_lab9;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damian Darczuk
 */
public class Konsument extends Thread {
    
    private Magazyn magazyn = null;
    private final String imie;
    
    public Konsument(Magazyn magazyn, Integer imie){
        this.magazyn = magazyn;
        this.imie = imie.toString();
    }
    
    @Override
    public void run(){        
        Random r = new Random();
        int ilosc, numer;
        while(true){
            
            try {
                ilosc = r.nextInt(20);
                numer = r.nextInt(9);
                
                System.out.println("Pobieram  " + this.imie + " towar: " + numer + " w ilosci: " + ilosc + "!");
                magazyn.pobierzTowar(numer, ilosc);
                
                sleep(r.nextInt(10000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Konsument.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
