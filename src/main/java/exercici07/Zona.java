/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

import java.util.Arrays;

public abstract class Zona {
    private final int SEIENT_LLIURE = 0;
    private final int SEIENT_OCUPAT = 1;
    private int [][] zona;
    private int seientsLliures;
    public Zona(int numFiles, int seientsPerFila) {
        zona = new int [numFiles][seientsPerFila];
        plenarZona();
        seientsLliures = numFiles * seientsPerFila;
    }

    public int getSeientsLliures() {
        return seientsLliures;
    }

    public void plenarZona(){
        for (int i=0; i<zona.length; i++){
            for (int z=0; z<zona[i].length; z++){
                zona [i][z] = SEIENT_LLIURE;
            }
        }
    }

    public int[][] getZona() {
        return zona;
    }

    public void setSeientOcupat(int fila, int seient){
        zona [fila][seient] = SEIENT_OCUPAT;
    }

    public void setSeientLiure(int fila, int seient){
        zona [fila][seient] = SEIENT_LLIURE;
    }

    public void mostrarZonas(){
        for (int i=0; i < zona.length; i++){
            for (int z=0; z < zona[i].length; z++)
                if (zona[i][z] == 0) {
                    System.out.print(" | F:" + i + ", S:" + z + ", D:" +"\u001B[32m" + zona[i][z] +"\u001B[0m" + " | ");
                }
                else{
                    System.out.print(" | F:" + i + ", S:" + z + ", D:" +"\u001B[31m" + zona[i][z] +"\u001B[0m" + " | ");
                }
            System.out.println("\n----------------------------------------");

        }
    }
}
