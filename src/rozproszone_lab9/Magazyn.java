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
public class Magazyn {
    
    private final int magazyn[];
    private final int pojemnoscMagazynu = 100;
    
    public Magazyn(){
        magazyn = new int[10];
    }
    
    public synchronized int getMagazyn(int numerTowaru){
        return this.magazyn[numerTowaru];
    }
    
    public synchronized void pobierzTowar(int numerTowaru, int iloscTowaru){
        
        //if(magazyn[numerTowaru] == 0)
            //return 0;
        if(magazyn[numerTowaru] >= iloscTowaru ) {
            this.magazyn[numerTowaru] -= iloscTowaru;
            System.out.println("Stan towaru po pobraniu " + numerTowaru + ":" + getMagazyn(numerTowaru));            
        } 
        else if(magazyn[numerTowaru] > 0 &&  magazyn[numerTowaru] < iloscTowaru){
            this.magazyn[numerTowaru] = 0;
            System.out.println("Stan towaru  po pobraniu " + numerTowaru + ":" + getMagazyn(numerTowaru));
        }
        
    }
    
    public synchronized void dostarczTowar(int numerTowaru, int iloscTowaru){
        
        if((magazyn[numerTowaru] + iloscTowaru) <= pojemnoscMagazynu) {
            this.magazyn[numerTowaru] += iloscTowaru;
            System.out.println("Stan towaru po dostawie " + numerTowaru + ":" + getMagazyn(numerTowaru));
        }
        else if((magazyn[numerTowaru] + iloscTowaru) > pojemnoscMagazynu) {
            this.magazyn[numerTowaru] = 100;
            System.out.println("Stan towaru po dostawie " + numerTowaru + ":" + getMagazyn(numerTowaru));
        }
    }
   
}
