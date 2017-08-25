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
public class Rey extends Pieza {

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
    public boolean movimientos(Object[][] matriz, int x, int y, int x1, int y1) {
        if (y == y1) {
            for (int i = 1; i <= x1 - x; i++) {
                if (matriz[x + i][y] instanceof Pieza) {
                    System.out.println("Movimiento no permitido por las Reglas del Juego");
                    return false;
                }

            }
            if (x1 > x) {
                for (int i = 1; i <= x1 - x; i++) {
                    if (matriz[x + i][y] instanceof Pieza) {
                        System.out.println("Movimiento no permitido por las Reglas del Juego");
                        return false;
                    }
                }
            } else {
                for (int i = 1; i <= x - x1; i++) {
                    if (matriz[x - i][y] instanceof Pieza) {
                        System.out.println("Movimiento no permitido por las Reglas del Juego");
                        return false;
                    }
                }
            }
            return true;
        } else {
            if (x == x1) {
                for (int i = 1; i <= y1 - y; i++) {
                    if (matriz[x][y + i] instanceof Pieza) {
                        System.out.println("Movimiento no permitido por las Reglas del Juego");
                        return false;
                    }
                }
                if (y1 < y) {
                    for (int i = 1; i <= y - y1; i++) {
                        if (matriz[x][y - i] instanceof Pieza) {
                            System.out.println("Movimiento no permitido por las Reglas del Juego");
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }
 
  
    @Override
    public String toString() {
        return "£";
    }
}
