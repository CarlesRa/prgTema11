/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import java.util.ArrayList;
import java.util.Collections;

public class Inventari {
    private ArrayList<Multimedia> listadoMultimedia;
    private ArrayList <Socio> listadoSocios;

    public Inventari() {
        listadoMultimedia = new ArrayList<>();
        listadoSocios = new ArrayList<>();
    }

    public ArrayList<Multimedia> getListadoMultimedia() {
        return listadoMultimedia;
    }

    public ArrayList<Socio> getListadoSocios() {
        return listadoSocios;
    }

    public void mostrarMultimedias(){
        for (Multimedia m : listadoMultimedia){
            System.out.println(m.toString());
        }
    }

    public void mostrarVideojocsPerAny(){
        ArrayList<Multimedia> videoJocs = new ArrayList<>();
        for (Multimedia m : listadoMultimedia){
            if (m instanceof VideoJoc){
                videoJocs.add(m);
            }
        }
        Collections.sort(videoJocs);
        System.out.println(videoJocs.toString());
    }

    public void mostrarPeliculesPerTitol(){
        ArrayList<Multimedia> pelicules = new ArrayList<>();
        for (Multimedia m : listadoMultimedia){
            if (m instanceof Pelicula){
                pelicules.add(m);
            }
        }
        Collections.sort(pelicules);
        System.out.println(pelicules.toString());
    }

    public void mostrarLlogersPerData(){

    }
}
