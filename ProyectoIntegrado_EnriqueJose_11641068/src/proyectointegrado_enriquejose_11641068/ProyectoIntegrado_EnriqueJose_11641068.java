package proyectointegrado_enriquejose_11641068;

import java.awt.Color;

/**
 *
 * @author enriq
 */
public class ProyectoIntegrado_EnriqueJose_11641068 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object[][] matrix = new Object[19][19];
        matrix= Tablero();
        imprimirmatriz(matrix,0,0);

    }
    public static void imprimirmatriz(Object[][] matriz, int filas, int colum){
        if (filas == matriz.length -1 && colum == matriz[0].length -1) {
            System.out.print("["+matriz[filas][colum]+"]");
        }else{
            if (colum == matriz[0].length-1) {
                System.out.println("["+matriz[filas][colum]+"]");
                imprimirmatriz(matriz,filas+1,0);
            }else{
                System.out.print("["+matriz[filas][colum]+"]");
                imprimirmatriz(matriz,filas,colum+1);
            }
        }
    }
    public static Object[][] Tablero() {
        Object matriz[][] = {
            {"X", "X", new Rebelde(Color.BLACK), " ", " ",new Rebelde(Color.BLACK) , " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), "X", "X"},
            {"X", "X", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "X", "X"},
            {new Rebelde(Color.BLACK), " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", new Rebelde(Color.BLACK)},
            {" ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " "},
            {new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK)," ", new Rebelde(Color.BLACK)},
            {" ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", new Duque(Color.WHITE), " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " "},
            {" ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " "},
            {" ", " ", " ", " ", new Duque(Color.WHITE), " ", " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), "", "",new Duque(Color.WHITE), " ", " ", " ", " "},
            {" ", " ", " ", new Rebelde(Color.BLACK), " ", " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), "REY", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", new Rebelde(Color.BLACK), " ", " ", " ", " "},//Centro
            {" ", " ", " ", " ", new Duque(Color.WHITE), " ", " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", " ", new Duque(Color.WHITE), " ", " ", " ", " "},
            {" ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " "},
            {" ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " "},
            {new Rebelde(Color.BLACK)," ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK)," ", " ", new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK)},
            {" ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", new Duque(Color.WHITE), " ", new Duque(Color.WHITE), " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK), " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " "},
            {new Rebelde(Color.BLACK), " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", new Rebelde(Color.BLACK)},
            {"X", "X", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "X", "X"},
            {"X", "X", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), " ", " ", " ", " ", " ", " ", " ", new Rebelde(Color.BLACK), " ", " ", new Rebelde(Color.BLACK), "X", "X"}};
        return matriz;
    }
}
