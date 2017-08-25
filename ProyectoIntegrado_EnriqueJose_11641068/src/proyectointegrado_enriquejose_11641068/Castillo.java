/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegrado_enriquejose_11641068;

import java.awt.Color;

/**
 *
 * @author enriq
 */
public class Castillo extends Pieza{
    private Color c;
    private boolean gana;

    public Castillo() {
    }

    public Castillo(Color c) {
        this.c = c;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public boolean isGana() {
        return gana;
    }

    public void setGana(boolean gana) {
        this.gana = gana;
    }

 

    @Override
    public String toString() {
        return "X";
    }

    
}
