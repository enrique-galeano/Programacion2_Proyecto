package proyectointegrado_enriquejose_11641068;

import java.awt.Color;
import java.util.Scanner;

/**
 *
 * @author enriq
 */
public class ProyectoIntegrado_EnriqueJose_11641068 {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int x = 0, cont = 0, ayuda = 0, y = 0;
        int x1 = 0, y1 = 0;
        Pieza pieza = new Pieza();
        Object[][] matrix = new Object[19][19];
        matrix = Tablero();
        //imprimirmatriz(matrix, 0, 0);
        while (ayuda != 1) {
            imprimirmatriz(matrix, 0, 0);
            System.out.println("  ");
            System.out.println("Ingrese la coordenada de x: ");
            x = sc.nextInt();
            System.out.println("Ingrese la coordenada de y: ");
            y = sc.nextInt();
            if (matrix[x][y] instanceof Pieza) {
                if (matrix[x][y] instanceof Rebelde) {
                    System.out.println("Usted esta a punto de mover un Relbe");
                    if (cont % 2 == 0) {
                        System.out.println("Ingrese donde quiere mover en x ");
                        x1 = sc.nextInt();
                        System.out.println("Ingrese donde quiere mover en y ");
                        y1 = sc.nextInt();
                        pieza = (Pieza) matrix[x][y];
                        if (pieza.movimientos(matrix, x, y, x1, y1)) {
                            matrix[x1][y1] = matrix[x][y];
                            matrix[x][y] = " ";
                        }
                    }
                }
            }
            if (cont % 2 != 0) {

            }
        }
    }

    public static Object[][] Tablero() {
        Object matriz[][] = {
            {"X", "X", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), "X", "X"},
            {"X", "X", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "X", "X"},
            {new Rebelde(Color.BLACK), " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", new Rebelde(Color.BLACK)},
            {" ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " "},
            {new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK)},
            {" ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", new Duque(Color.WHITE), " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " "},
            {" ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " "},
            {" ", " ", " ", " ", new Duque(Color.WHITE), " ", " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", " ", new Duque(Color.WHITE), " ", " ", " ", " "},
            {" ", " ", " ", new Rebelde(Color.BLACK), " ", " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), new Rey(Color.BLUE), new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", " ", new Rebelde(Color.BLACK), " ", " ", " "},//Centro
            {" ", " ", " ", " ", new Duque(Color.WHITE), " ", " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", " ", new Duque(Color.WHITE), " ", " ", " ", " "},
            {" ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " "},
            {" ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", new Duque(Color.WHITE), " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " "},
            {new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK)},
            {" ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " "},
            {new Rebelde(Color.BLACK), " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", new Rebelde(Color.BLACK)},
            {"X", "X", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "X", "X"},
            {"X", "X", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), "X", "X"}};
        return matriz;
    }

    public static void imprimirmatriz(Object[][] matriz, int filas, int colum) {
        if (filas == matriz.length - 1 && colum == matriz[0].length - 1) {
            System.out.print("[" + matriz[filas][colum] + "]");
        } else {
            if (colum == matriz[0].length - 1) {
                System.out.println("[" + matriz[filas][colum] + "]");
                imprimirmatriz(matriz, filas + 1, 0);
            } else {
                System.out.print("[" + matriz[filas][colum] + "]");
                imprimirmatriz(matriz, filas, colum + 1);
            }
        }
    }
}
