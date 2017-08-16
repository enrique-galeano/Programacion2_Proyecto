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
public class Duque extends Pieza{
    private Color color;

    public Duque(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean movimientos(Object[][] matriz, int x, int y, int x1, int y1) {
      return false;
    }
    
   

    @Override
    public String toString() {
        return "O";
    }
    
    
}
