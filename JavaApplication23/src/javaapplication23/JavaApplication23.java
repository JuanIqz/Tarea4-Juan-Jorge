/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication23;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class JavaApplication23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner pd = new Scanner(System.in);
        int menu = 0;
        System.out.println("Bienvenido a los ejercicios de practica opcionales");
        System.out.println("Sus opciones son las siguientes:");
        System.out.println();
        System.out.println("1. Yo no le tengo miedo a nada");
        System.out.println("2. Yo no le tengo miedo a nada, pero soy precavido.");
        System.out.println();
        System.out.println("Marque el numero que esta enfrente de la opcion para acceder a ella: ");
        menu = pd.nextInt();
        switch (menu) {

            case 1:
                System.out.println("Bienvenido a Yo no le tengo miedo a nada");
                String [][]mapa1=new String[6][5];
                tabship1(mapa1);
                System.out.println();
                System.out.println("---------------------");
                System.out.println();
                String [][]mapa2=new String[6][5];
                tabship2(mapa2);
                break;

            case 2:

                System.out.println("Bienvenido a Yo no le tengo miedo a nada, pero soy precavido.");
                Random random = new Random();
                int a = random.nextInt(4);
                int b = random.nextInt(4);
                String[][] tablero = new String[5][5];
                MatrizMinas(tablero, a, b);
                break;

            default:
                System.out.println("opcion no valida");
                break;
        }
    }
//metodos busca minas
    public static int validacionFMinas(int CorF) {
        Scanner pd = new Scanner(System.in);
        while (CorF > 4 || CorF < 0) {
            System.out.println("Valor invalido favor de ingresar otro menor que 4 y superior a 0: ");
            CorF = pd.nextInt();
        }
        return CorF;
    }

    public static int validacionCMinas(int CorC) {
        Scanner pd = new Scanner(System.in);
        while (CorC > 4 || CorC < 0) {
            System.out.println("Valor invalido favor de ingresar otro menor que 4 y superior a 0: ");
            CorC = pd.nextInt();
        }
        return CorC;
    }

    public static String[][] MatrizActualizada(String[][] matriza, String a) {
        Scanner pd = new Scanner(System.in);
        boolean bandi = true;
        while (bandi) {
            System.out.println("Favor de ingresar el numero de fila en el que pondra una X: ");
            int posF = pd.nextInt();
            int x = validacionFMinas(posF);
            System.out.println("Favor de ingresar el numero de columna en el que pondra una y: ");
            int posC = pd.nextInt();
            int y = validacionCMinas(posC);
            for (int i = 0; i < matriza.length; i++) {
                for (int j = 0; j < matriza[i].length; j++) {
                    if (i == x && j == y) {
                        matriza[x][y] = "[ " + "X" + " ]";
                        System.out.print(matriza[x][y]);
                    } else {
                        System.out.print(matriza[i][j]);
                    }

                }
                System.out.println(" ");

            }
            if (matriza[x][y].regionMatches(x, a, x, y)) {
                bandi = true;
                System.out.println("Uff, no era bomba, continue");
            } else {
                System.out.println("BOOM");
                bandi = false;
            }
        }
        String[][] MatrizActualizadaF = matriza;

        return MatrizActualizadaF;

    }

    public static String[][] MatrizMinas(String[][] matriz, int x, int y) {

        for (int i = 0; i < matriz.length; i++) {//filas
            for (int j = 0; j < matriz[i].length; j++) {//columnas
                if (i == x || j == y) {
                    matriz[x][y] = "[ " + "*" + " ]";
                    System.out.print(matriz[x][y]);
                } else {
                    matriz[i][j] = "[ " + " ]";
                    System.out.print(matriz[i][j]);
                }
            }
            System.out.println(" ");
        }
        String[][] MatrizMinado = matriz;
        return MatrizActualizada(MatrizMinado, matriz[x][y]);
    }
//fin metodos busca minas
    
//metodos battleship
    public static String[][] tabship1 (String[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]="[ " + " ]";
                map[0][0]="[ " + "*" + " ]";
                map[1][0]="[ " + "*" + " ]";
                map[2][0]="[ " + "*" + " ]";
                map[1][2]="[ " + "*" + " ]";
                map[1][3]="[ " + "*" + " ]";
                map[3][4]="[ " + "*" + " ]";
                map[4][4]="[ " + "*" + " ]";
                map[5][4]="[ " + "*" + " ]";
                
                System.out.print(map[i][j]);
            }
            System.out.println(" ");
        }
        String[][] Matrizguardar1 = map;
        return  ActualG(Matrizguardar1,Matrizguardar1);
    }
    
    public static String[][] tabship2 (String[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]="[ " + " ]";
                map[3][1]="[ " + "*" + " ]";
                map[4][1]="[ " + "*" + " ]";
                map[5][1]="[ " + "*" + " ]";
                map[1][3]="[ " + "*" + " ]";
                map[2][3]="[ " + "*" + " ]";
                map[3][3]="[ " + "*" + " ]";
                map[5][3]="[ " + "*" + " ]";
                map[5][4]="[ " + "*" + " ]";
                
                System.out.print(map[i][j]);
            }
            System.out.println(" ");
        }
        String[][] Matrizguardar2 = map;
        return  ActualG(Matrizguardar2,Matrizguardar2);
    }
    
     public static int validacionAtaque1x(int CorF) {
        Scanner pd = new Scanner(System.in);
        while (CorF > 6 || CorF < 0) {
            System.out.println("Valor invalido favor de ingresar otro menor que 6 y superior a 0: ");
            CorF = pd.nextInt();
        }
        return CorF;
    }

    public static int validacionAtaque1y(int CorC) {
        Scanner pd = new Scanner(System.in);
        while (CorC > 5 || CorC < 0) {
            System.out.println("Valor invalido favor de ingresar otro menor que 5 y superior a 0: ");
            CorC = pd.nextInt();
        }
        return CorC;
    }
    
     public static int validacionAtaque2x(int CorF) {
        Scanner pd = new Scanner(System.in);
        while (CorF > 6 || CorF < 0) {
            System.out.println("Valor invalido favor de ingresar otro menor que 6 y superior a 0: ");
            CorF = pd.nextInt();
        }
        return CorF;
    }

    public static int validacionAtaque2y(int CorC) {
        Scanner pd = new Scanner(System.in);
        while (CorC > 5 || CorC < 0) {
            System.out.println("Valor invalido favor de ingresar otro menor que 5 y superior a 0: ");
            CorC = pd.nextInt();
        }
        return CorC;
    }
    
    public static int validPT(int Np){
        Scanner pd = new Scanner(System.in);
        while(Np>2|| Np < 1){
             System.out.println("Valor invalido favor de ingresar otro menor que 3 y superior o igual a 1: ");
             Np=pd.nextInt();
        }
        return Np;    
    }
    
    public static String [][] ActualG(String[][] map1,String[][] map2) {
        Scanner pd = new Scanner(System.in);
        System.out.println("De quien es turno: ");
        int P=pd.nextInt();
        int PS=validPT(P);
        
        if(PS==1&&PS!=2){
            System.out.println("Turno del jugador 1");
            System.out.println("Ingrese la cordenada de fila que quiere atacar: ");
            int PosF=pd.nextInt();
            int a= validacionAtaque1x(PosF);
            System.out.println("Ingrese la cordenada de columna que quiere atacar: ");
            int PosC=pd.nextInt();
            int b= validacionAtaque1y(PosC);
        }
        
        return  map2;
    }
}


    
    

