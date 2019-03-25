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
        StringBuilder punts = new StringBuilder();
        for (int i=0; i<puntsPoligon.size(); i++){
            punts.append(puntsPoligon.get(i)).append("\n");
        }
        return punts.toString();
    }

    public double perimetre(ArrayList<Punt>punts){
        double perimetro = 0;
        perimetro = puntsPoligon.get(0).distancia(puntsPoligon.get(puntsPoligon.size()-1));
        for (int i=0; i<puntsPoligon.size()-1; i++){
            perimetro += puntsPoligon.get(i).distancia(puntsPoligon.get(i+1));
        }
        return perimetro;
    }

}
