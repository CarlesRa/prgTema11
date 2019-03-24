package exercici02;

import exercici01.Punt;

import java.util.ArrayList;

public class Poligon {
    private ArrayList <Punt> puntsPoligon;

    public Poligon(ArrayList<Punt> puntsPoligon) {
        this.puntsPoligon = puntsPoligon;
    }

    public void trasllada(double x, double y){
        for (int i=0; i<puntsPoligon.size(); i++){
            puntsPoligon.get(i).setX(puntsPoligon.get(i).getX() + x);
            puntsPoligon.get(i).setY(puntsPoligon.get(i).getY() + y);
        }
    }

    public int numVertex(){
        return puntsPoligon.size();
    }

    @Override
    public String toString() {
        for (Punt punt: puntsPoligon){
            System.out.println(punt.toString());
        }
        return puntsPoligon.toString();
    }

    public double perimetre(ArrayList<Punt>punts){
        double perimetro = 0;
        perimetro = distanciaEntrePunts(punts.get(0),punts.get(punts.size()-1));
        for (int i=0; i<puntsPoligon.size()-1; i++){
            perimetro += distanciaEntrePunts(punts.get(i),punts.get(i+1));
        }
        return perimetro;
    }

    public double distanciaEntrePunts(Punt p1, Punt p2){
        double distancia = Math.sqrt(Math.pow((p2.getX() - p1.getX()),2)
        + Math.pow((p2.getY() - p1.getY()),2));
        return distancia;
    }
}
