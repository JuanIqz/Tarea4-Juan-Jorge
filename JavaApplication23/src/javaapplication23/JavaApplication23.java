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
        Scanner pd= new Scanner (System.in);
        int menu=0;
        System.out.println("Bienvenido a los ejercicios de practica opcionales");
        System.out.println("Sus opciones son las siguientes:");
        System.out.println();
        System.out.println("1. Yo no le tengo miedo a nada");
        System.out.println("2. Yo no le tengo miedo a nada, pero soy precavido.");
        System.out.println();
        System.out.println("Marque el numero que esta enfrente de la opcion para acceder a ella: ");
        menu= pd.nextInt();
        switch(menu){
            
            case 1:
                System.out.println("hola1");
                break;
            
            case 2:
                System.out.println("Bienvenido a Yo no le tengo miedo a nada, pero soy precavido.");
                Random random = new Random();
                int a = random.nextInt(4);
                int b = random.nextInt(4);
                String [][]tablero=new String [5][5];
                String [][]tableromarcado=new String [5][5];
                String [][]tablerominado=MatrizMinas(tablero,a,b);
                System.out.println();
                System.out.println("-----------------");
                System.out.println();
                for (int i = 0; i < tablerominado.length; i++) {
                    for (int j = 0; j < tablerominado[i].length; j++) {
                        System.out.print(""+tablerominado[i][j]);
                    }
                    System.out.println("");
                }
                System.out.println();
                System.out.println("-----------------");
                System.out.println();
                tableromarcado=MatrizActualizada(tablerominado);
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }
    public static void ImprimirMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {//filas
            for (int j = 0; j < matriz[i].length; j++) {//columnas
                System.out.print("[ " + " ]");
            }
            System.out.println(" ");
        }
    }//fin del método
    
    public static int validacionFMinas(int CorF){
        Scanner pd = new Scanner(System.in);
        while (CorF > 4 || CorF < 0) {
            System.out.println("Valor invalido favor de ingresar otro menor que 4 y superior a 0: ");
            CorF = pd.nextInt();
        }
        return CorF;
    }
    
    public static int validacionCMinas(int CorC){
        Scanner pd = new Scanner(System.in);
        while (CorC > 4 || CorC < 0) {
            System.out.println("Valor invalido favor de ingresar otro menor que 4 y superior a 0: ");
            CorC = pd.nextInt();
        }
        return CorC;
    }
    
    public static String[][] MatrizActualizada( String[][] matriza){
        Scanner pd = new Scanner(System.in);
        int cont=0;
        while (cont <= 3) {
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
                        matriza[i][j] = "[ " + " ]";
                        System.out.print(matriza[i][j]);
                    }
                }
                System.out.println(" ");
            }
            matriza[x][y] = "[ " + "X" + " ]";
            cont += 1;
        }
        return matriza;
    }

    public static String[][] MatrizMinas(String[][] matriz, int x, int y) {

        for (int i = 0; i < matriz.length; i++) {//filas
            for (int j = 0; j < matriz[i].length; j++) {//columnas
                if (i == x && j == y) {
                    matriz[x][y]="[ " + "*" + " ]";
                    System.out.print(matriz[x][y]);
                } else {
                    matriz[i][j]="[ " + " ]";
                    System.out.print(matriz[i][j]);
                }
            }
            System.out.println(" ");
        }
        return matriz;
    }

}


    
    

