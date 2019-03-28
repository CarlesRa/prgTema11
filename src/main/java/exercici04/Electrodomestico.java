package exercici04;

import java.util.HashMap;

public class Electrodomestico {
    private static final double precioBase = 100;
    private static final String [] colores = {"Blanco","Negro","Rojo","Azul","Gris"};
    private static final char[] letrasConsumo = {'F','A','B','C','D','E'};
    private static final float pesoPredeterminado = 5;
    protected double precio;
    protected String color;
    protected char consumo;
    protected float peso;

    public Electrodomestico(){
        precio = precioBase + precioFinal();
        color = colores[0];
        consumo = letrasConsumo[0];
        peso = pesoPredeterminado;
    }
    public Electrodomestico(double precio, float peso){
        this.precio += precio + precioFinal();
        this.peso = peso;
        color = colores[0];
        consumo = letrasConsumo[0];
    }
    public Electrodomestico(double precio, String color, char consumo, float peso) {
        this.precio = precio += precioFinal();
        this.color = (comprovarColor(color)) ? color : colores[0];
        this.consumo = (comprovarConsumoEnergetico(consumo)) ? consumo : letrasConsumo[0];
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public String getColor() {
        return color;
    }

    public char getConsumo() {
        return consumo;
    }

    public float getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "precio=" + precio +
                ", color='" + color + '\'' +
                ", consumo=" + consumo +
                ", peso=" + peso
                ;
    }

    private boolean comprovarConsumoEnergetico(char letra){
        for (int i=0; i<letrasConsumo.length; i++){
            if (letrasConsumo[i] == letra){
                return true;
            }
        }
        return false;
    }

    private boolean comprovarColor(String color){
        for (int i=0; i<colores.length; i++){
            if (colores[i].equalsIgnoreCase(color)){
                return true;
            }
        }
        return false;
    }

    protected double precioFinal(){
        HashMap <Character,Integer> letraPrecio = new HashMap();
        letraPrecio.put('A',100);
        letraPrecio.put('B',80);
        letraPrecio.put('C',60);
        letraPrecio.put('D',50);
        letraPrecio.put('E',30);
        letraPrecio.put('F',10);
        this.precio += letraPrecio.get(this.consumo);
        if (this.peso >=0 || this.peso <=19){
            this.precio += 10;
        }
        else if (this.peso >=20 || this.peso <=49){
            this.precio += 50;
        }
        else if (this.peso >49 || this.peso <=79){
            this.precio += 80;
        }
        else if (this.peso >79){
            this.precio += 100;
        }
        return this.precio;
    }
}

