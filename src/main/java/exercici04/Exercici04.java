package exercici04;

import java.util.ArrayList;

public class Exercici04{
    private ArrayList <Electrodomestico> electrodomesticos;
    private double totalLavadoras;
    private double totaTelevisores;
    public Exercici04(){
        electrodomesticos = new ArrayList<>();
        electrodomesticos.add(new Television(100,45));
        electrodomesticos.add(new Television(250,41));
        electrodomesticos.add(new Television(200,"negro",'E',50,38,true));
        electrodomesticos.add(new Television(200,"blanco",'A',50,38,false));
        electrodomesticos.add(new Television());
        electrodomesticos.add(new Lavadora());
        electrodomesticos.add(new Lavadora(150,26));
        electrodomesticos.add(new Lavadora(150,"Amarillo",'Z',15,10));
        electrodomesticos.add(new Lavadora(100,"Amarillo",'F',5,31));
        electrodomesticos.add(new Lavadora(150,"gris",'D',15,31));

        for (int i=0; i<electrodomesticos.size(); i++){
            if (electrodomesticos.get(i) instanceof Lavadora){
                totalLavadoras += electrodomesticos.get(i).getPrecio();
                System.out.println("Lavadora: " + electrodomesticos.get(i).precioFinal() + "Eu");
                //System.out.println("Lavadora: " + electrodomesticos.get(i).toString());
                //System.out.println(electrodomesticos.get(i).getConsumo());
            }
            else if (electrodomesticos.get(i) instanceof Television){
                System.out.println("Television: " + electrodomesticos.get(i).precioFinal() + "Eu");
                totaTelevisores += electrodomesticos.get(i).getPrecio();
                //System.out.println("television: " + electrodomesticos.get(i).toString());
                //System.out.println(electrodomesticos.get(i).getConsumo());
            }
        }

        System.out.println("El precio de todas las lavadoras es: " + totalLavadoras);
        System.out.println("El precio de todas las Televisores es: " + totaTelevisores);
    }
}
