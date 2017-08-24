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
        int x2 = 0, y2 = 0;
        int x3 = 0, y3 = 0;
        Pieza pieza = new Pieza();
        Object[][] matrix = new Object[19][19];
        matrix = Tablero();
        //imprimirmatriz(matrix, 0, 0);
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
            System.out.println("   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19");
            imprimirmatriz(matrix, 0, 0);
            System.out.println("  ");
            if (cont % 2 == 0) {

                System.out.println(" ");
                System.out.println(jugador1 + " eres del bando de los Rebeldes");
                System.out.println("Ingrese la coordenada de x: ");
                x = sc.nextInt();
                System.out.println("Ingrese la coordenada de y: ");
                y = sc.nextInt();
                if (matrix[x][y] instanceof Pieza) {
                    if (matrix[x][y] instanceof Rebelde) {
                        System.out.println("Usted movera un Relbe");
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
                cont++;
            }
            System.out.println(" ");
            if (cont % 2 != 0) {
                imprimirmatriz(matrix, 0, 0);
                System.out.println(" ");
                String nombre;
                System.out.println("Jugador 2 " + jugador2);
                System.out.println("Quiere mover a un Duque a al rey");
                System.out.println("Ingrese el nombre del");
                nombre = sc.next();
                switch (nombre) {
                    case "duque":
                        System.out.println("Ingrese la coordenada de x: ");
                        x = sc.nextInt();
                        System.out.println("Ingrese la coordenada de y: ");
                        y = sc.nextInt();
                        System.out.println(jugador2 + " eres del bando de los Duques");
                        if (matrix[x][y] instanceof Pieza) {
                            if (matrix[x][y] instanceof Duque) {
                                System.out.println("Usted movera un Duque");
                                System.out.println("Ingrese donde quiere mover en x ");
                                x2 = sc.nextInt();
                                System.out.println("Ingrese donde quiere mover en y ");
                                y2 = sc.nextInt();
                                pieza = (Pieza) matrix[x][y];
                                if (pieza.movimientos(matrix, x, y, x2, y2)) {
                                    matrix[x2][y2] = matrix[x][y];
                                    matrix[x][y] = " ";
                                }
                            }
                        }
                        cont++;
                        break;
                    case "rey":
                        System.out.println("Ingrese la coordenada de x: ");
                        x = sc.nextInt();
                        System.out.println("Ingrese la coordenada de y: ");
                        y = sc.nextInt();
                        if (matrix[x][y] instanceof Pieza) {
                            if (matrix[x][y] instanceof Rey) {
                                System.out.println("Usted movera al rey");
                                System.out.println("Ingrese donde quiere moverlo en x ");
                                x3 = sc.nextInt();
                                System.out.println("Ingrese donde quiere moverlo en y ");
                                y3 = sc.nextInt();
                                pieza = (Pieza) matrix[x][y];
                                if (pieza.movimientos(matrix, x, y, x3, y3)) {
                                    matrix[x3][y3] = matrix[x][y];
                                    matrix[x][y] = " ";
                                }
                            }
                        }
                        break;
                }
                cont++;
            }
        }
    }

    public static Object[][] Tablero() {
        Object matriz[][] = {
            {new Castillo(Color.GRAY), new Castillo(Color.GRAY), new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), new Castillo(Color.GRAY), new Castillo(Color.GRAY)},
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
}
