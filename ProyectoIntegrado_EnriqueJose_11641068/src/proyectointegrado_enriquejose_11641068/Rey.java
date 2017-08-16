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
public class Rey extends Pieza{
    public Color color;

    public Rey() {
    }

    public Rey(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ω";
    }
    
    
    
    
}
