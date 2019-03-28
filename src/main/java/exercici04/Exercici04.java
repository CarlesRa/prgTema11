package exercici04;

import java.util.ArrayList;

public class Exercici04 {
    private ArrayList <Electrodomestico> electrodomesticos;
    public Exercici04(){
        electrodomesticos = new ArrayList<>();
        electrodomesticos.add(new Television(100,35));
        electrodomesticos.add(new Television(250,40));
        electrodomesticos.add(new Television(200,"negro",'E',50,48,true));
        electrodomesticos.add(new Television(200,"blanco",'A',50,48,false));
        electrodomesticos.add(new Television());
        electrodomesticos.add(new Lavadora());
        electrodomesticos.add(new Lavadora(150,26));
        electrodomesticos.add(new Lavadora(150,"Amarillo",'Z',15,10));
        electrodomesticos.add(new Lavadora(150,"Amarillo",'C',15,31));
        electrodomesticos.add(new Lavadora(150,"gris",'D',15,31));

        for (int i=0; i<electrodomesticos.size(); i++){
            if (electrodomesticos.get(i) instanceof Lavadora){
                //System.out.println("Lavadora: " + electrodomesticos.get(i).precioFinal() + "Eu");
                System.out.println("Lavadora: " + electrodomesticos.get(i).toString());
            }
            else if (electrodomesticos.get(i) instanceof Television){
                //System.out.println("Television: " + electrodomesticos.get(i).precioFinal() + "Eu");
                System.out.println("television: " + electrodomesticos.get(i).toString());
            }
        }

    }
}
