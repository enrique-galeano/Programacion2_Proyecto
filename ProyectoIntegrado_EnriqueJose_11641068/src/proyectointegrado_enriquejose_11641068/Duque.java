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
public class Duque extends Pieza {

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
        } else if (x == x1) {
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
            return true;
        } else {
            System.out.println("Movimiento invalido no es permitido moverse en diagonal");
            return false;

        }
    }

    @Override
    public boolean capturar(Object[][] matriz, int x, int y) {
        if (x >= 0 && y >= 0 && x < matriz.length - 1 && y < matriz.length - 1) {
            if (matriz[x][y + 1] instanceof Rebelde && matriz[x][y - 1] instanceof Rebelde) {
                return true;
            } else if (matriz[x][y - 1] instanceof Rebelde && matriz[x][y + 1] instanceof Rebelde && matriz[x + 1][y] instanceof Rebelde) {
                return true;
            } else if (matriz[x][y] instanceof Rebelde && matriz[x][y + 1] instanceof Rebelde && matriz[x + 1][y] instanceof Rebelde) {
                return true;
            }
            if (matriz[x+1][y-1] instanceof Rey || matriz[x][y+1] instanceof Rey || matriz[x+1][y+1] instanceof Rey ||
                    matriz[x-1][y] instanceof Rey || matriz[x+1][y] instanceof Rey || matriz[x-1][y-1] instanceof Rey ||
                    matriz[x][y-1] instanceof Rey || matriz[x+1][y+1] instanceof Rey) {
                return false;
            }
            return false;
            
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "O";
    }
}
