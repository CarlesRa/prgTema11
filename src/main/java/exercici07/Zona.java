/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

import java.util.Arrays;

public abstract class Zona {
    private String [][] zona;
    private int seientsLliures;
    public Zona(int numFiles, int seientsPerFila) {
        zona = new String [numFiles][seientsPerFila];
        plenarZona();
        seientsLliures = numFiles * seientsPerFila;
    }

    public int getSeientsLliures() {
        return seientsLliures;
    }

    public void plenarZona(){
        for (int i=0; i<zona.length; i++){
            for (int z=0; z<zona[i].length; z++){
                zona [i][z] = "\u001B[42m ";
                System.out.print("\u001B[0m ");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<zona.length; i++){
            for (int z=0; z<zona[i].length; z++){
                sb.append("|").append(zona [i][z]).append("|");
            }
            System.out.println();
        }
        return sb.toString();
    }
}
