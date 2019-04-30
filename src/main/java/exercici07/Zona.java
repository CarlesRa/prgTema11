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

    public void setSeient(int fila, int seient){
        zona [fila][seient] = SEIENT_OCUPAT;
    }

    public void mostrarZonas(){
        for (int i=0; i < zona.length; i++){
            for (int z=0; z < zona[i].length; z++)
                System.out.print(" | F:" + i + ", S:" + z + ", D:" + zona[i][z]+ " | ");
            System.out.println("\n----------------------------------------");

        }
    }
}
