/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

import utils.Lib;

import java.util.ArrayList;

public class Sorteig {
    private ArrayList<Integer> nombresSorteigEntrada;
    private ArrayList<Integer> nombresSorteig;
    public Sorteig(int numLocalitats){
        nombresSorteigEntrada = new ArrayList<>();
        nombresSorteig = new ArrayList<>();
        plenarBombos(numLocalitats);
    }

    public void addnombresSorteigEntrada(int numSorteig) {
        nombresSorteigEntrada.add(numSorteig);
    }

    public void plenarBombos(int numLocalitats){
        for (int i=0; i<numLocalitats; i++){
            nombresSorteigEntrada.add(i);
            nombresSorteig.add(i);
        }
    }

    public int numeroSorteigEntrada(){
        int random = Lib.random(0, nombresSorteigEntrada.size()-1);
        int numSorteig = nombresSorteigEntrada.get(random);
        nombresSorteigEntrada.remove(random);
        return numSorteig;
    }

    public int generarSorteig(Partit partit){
        return nombresSorteig.get(Lib.random(0,nombresSorteig.size()-1));
    }
}
