/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

import java.util.Date;

/**
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class Salg {
    private Date tidsstempel;
    private boolean erFærdig;
    public Salg(Date tidsstempel, boolean erFærdig){
        this.tidsstempel = tidsstempel;
        this.erFærdig = erFærdig;
    }
}
