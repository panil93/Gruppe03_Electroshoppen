/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

/**
 *
 * @author Laura
 */
public class Service extends Varer {
  
    private String navn;
    
    public Service(String CompanyId, String navn, double RetailPrice){
      super(RetailPrice, CompanyId);
        this.navn = navn;
    
    }
  
    public String getNavn(){
        return this.navn;
    }
       @Override
    public String toString() {
        return (this.navn+" "+ RetailPrice);
        
        
    }
}
