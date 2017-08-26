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
        int x = 0, cont = 0, ayuda = 0, y = 0, ayuda2 = 0;
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;
        int x3 = 0, y3 = 0;
        Pieza pieza = new Pieza();
        Object[][] matrix = new Object[19][19];
        matrix = Tablero();
        System.out.println("Bienvenido al Jugo de Mesa Alea Evangelii\n"
                + "Reglas del juego\n"
                + "1) NO se puede pasar por ensima de un aliado\n"
                + "2) Solo el Rey puede ocupar el castillo X \n"
                + "3) Los cuatro duques que estan al rededor del Rey son imunes");
        System.out.println("Ingrese su nombre Jugador 1 ");
        String jugador1 = sc.next();
        System.out.println("Ingrese su nombre Jugador 2");
        String jugador2 = sc.next();
        while (ayuda != 1) {
            System.out.println("   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18");
            imprimirmatriz(matrix, 0, 0);
            System.out.println("  ");
            if (cont % 2 == 0 && ayuda != 1) {
                System.out.println(" ");
                System.out.println("Jugador 1 " + jugador1 + " tu estas con los rebeldes");
                System.out.println("Ingrese la coordenada de ");
                x = sc.nextInt();
                System.out.println("Ingrese la coordenada de ");
                y = sc.nextInt();
                if (matrix[x][y] instanceof Pieza) {
                    if (matrix[x][y] instanceof Rebelde) {
                        System.out.println("Usted movera un Relbe");
                        System.out.println("Ingrese donde quiere mover en ");
                        x1 = sc.nextInt();
                        System.out.println("Ingrese donde quiere mover en ");
                        y1 = sc.nextInt();
                        pieza = (Pieza) matrix[x][y];
                        if (pieza.movimientos(matrix, x, y, x1, y1)) {
                            matrix[x1][y1] = matrix[x][y];
                            matrix[x][y] = " ";
                        }
                    }
                }
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (matrix[i][j] instanceof Duque) {
                            if (((Duque) matrix[i][j]).capturar(matrix, i, j)) {
                                matrix[i][j] = " ";
                            }
                        }
                    }
                }
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        if (matrix[i][j] instanceof Rey) {
                            if (((Rey) matrix[i][j]).capturar(matrix, i, j)) {
                                ayuda = 1;
                                System.out.println("Ganaron los Rebeldes");
                                matrix[i][j] = " ";
                            }
                        }
                    }
                }
                cont++;
            }
            System.out.println(" ");
            if (cont % 2 != 0 && ayuda != 1) {
                System.out.println("   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18");
                imprimirmatriz(matrix, 0, 0);
                System.out.println(" ");
                String nombre;
                System.out.println("Jugador 2 " + jugador2 + "tu estas con el Rey y los duques  ");
                System.out.println("Ingrese la coordenada de ");
                x = sc.nextInt();
                System.out.println("Ingrese la coordenada de  ");
                y = sc.nextInt();
                if (matrix[x][y] instanceof Pieza) {
                    if (matrix[x][y] instanceof Duque) {
                        System.out.println("Usted movera un Duque");
                        System.out.println("Ingrese donde quiere mover en ");
                        x2 = sc.nextInt();
                        System.out.println("Ingrese donde quiere mover en  ");
                        y2 = sc.nextInt();
                        pieza = (Pieza) matrix[x][y];
                        if (pieza.movimientos(matrix, x, y, x2, y2)) {
                            matrix[x2][y2] = matrix[x][y];
                            matrix[x][y] = " ";
                        }

                    }
                    if (matrix[x][y] instanceof Rey) {
                        System.out.println("Usted movera al Rey");
                        System.out.println("Ingrese donde quiere mover en x ");
                        x2 = sc.nextInt();
                        System.out.println("Ingrese donde quiere mover en y ");
                        y2 = sc.nextInt();
                        pieza = (Pieza) matrix[x][y];

                        if (matrix[x2][y2] instanceof Castillo) {
                            System.out.println("El Rey llego al castillo");
                            System.out.println("Ganoron los Reyes y Duques");
                            ayuda = 1;
                        } else if (pieza.movimientos(matrix, x, y, x2, y2)) {

                            matrix[x2][y2] = matrix[x][y];
                            matrix[x][y] = " ";
                            if (x == 9 && y == 9) {
                                matrix[x][y] = new Castillo(Color.GRAY);
                            }
                        }

                    }
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            if (j == 0 && i < matrix.length - 1) {
                                if (matrix[i + 1][j] instanceof Rebelde) {
                                    if (((Rebelde) matrix[i + 1][j]).capturar(matrix, i + 1, j)) {
                                        matrix[i + 1][j] = " ";

                                    }
                                }
                            }
                        }
                    }
                }
                cont++;
            }
        }
    }

    public static Object[][] Tablero() {
        Object matriz[][] = {{new Castillo(Color.GRAY), new Castillo(Color.GRAY), new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), new Castillo(Color.GRAY), new Castillo(Color.GRAY)},
        {new Castillo(Color.GRAY), new Castillo(Color.GRAY), " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", new Castillo(Color.GRAY), new Castillo(Color.GRAY)},
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
        {new Castillo(Color.GRAY), new Castillo(Color.GRAY), " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", new Castillo(Color.GRAY), new Castillo(Color.GRAY)},
        {new Castillo(Color.GRAY), new Castillo(Color.GRAY), new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), new Castillo(Color.GRAY), new Castillo(Color.GRAY)}};
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
                if (colum == 0) {
                    if (filas <= 9) {
                        System.out.print(" " + filas);
                    } else {

                        System.out.print(filas);
                    }
                }
                System.out.print("[" + matriz[filas][colum] + "]");
                imprimirmatriz(matriz, filas, colum + 1);
            }
        }
    }
    /*public boolean ganar(Object Castillo, Object Rey){
        if (Castillo.equals(Rey)) {
            return true;
        }else{
            return false;
        }*/
}
