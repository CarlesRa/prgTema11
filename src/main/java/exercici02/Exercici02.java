package exercici02;

import exercici01.Punt;

import java.util.ArrayList;

public class Exercici02 {
    private ArrayList<Punt>puntsPoligon;
    public Exercici02(){
        puntsPoligon = new ArrayList<>();
        puntsPoligon.add(new Punt(0.0,0.0));
        puntsPoligon.add(new Punt(2.0,0.0));
        puntsPoligon.add(new Punt(2.0,2.0));
        puntsPoligon.add(new Punt(0.0,2.0));
        Poligon p1 = new Poligon(puntsPoligon);
        System.out.println("Els punts del polígon son: \n");
        System.out.println(p1.toString());
        System.out.println("Te un total de: " + p1.numVertex() + " vertex.");
        System.out.println("El seu perímetre es: " + p1.perimetre(puntsPoligon) + "\n");
        System.out.println("Traslladem el polígon +4 en 'x' i -3 en 'y': ");
        p1.trasllada(4,-3);
        System.out.println("Els punts del polígon son: \n");
        p1.toString();
        System.out.println("Te un total de: " + p1.numVertex() + " vertex.");
        System.out.println("El seu perímetre es: " + p1.perimetre(puntsPoligon));

    }
}
