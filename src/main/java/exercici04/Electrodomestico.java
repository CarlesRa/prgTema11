package exercici04;

import java.util.HashMap;

public class Electrodomestico {
    private static final double PRECIO_BASE = 100;
    private static final String [] COLORES = {"Blanco","Negro","Rojo","Azul","Gris"};
    private static final char[] LETRAS_CONSUMO = {'F','A','B','C','D','E'};
    private static final float PESO_PREDETERMINADO = 5;
    protected double precio;
    protected String color;
    protected char consumo;
    protected float peso;

    public Electrodomestico(){
        this(PRECIO_BASE, COLORES[0], LETRAS_CONSUMO[0], PESO_PREDETERMINADO);
    }
    public Electrodomestico(double precio, float peso){
        this(precio, COLORES[0], LETRAS_CONSUMO[0],peso);
    }
    public Electrodomestico(double precio, String color, char consumo, float peso) {
        this.color = (comprovarColor(color)) ? color : COLORES[0];
        this.consumo = (comprovarConsumoEnergetico(consumo)) ? consumo : LETRAS_CONSUMO[0];
        this.peso = peso;
        this.precio = precio;
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
        return "precio=" + precioFinal() +
                ", color='" + color + '\'' +
                ", consumo=" + consumo +
                ", peso=" + peso
                ;
    }

    private boolean comprovarConsumoEnergetico(char letra){
        for (int i = 0; i< LETRAS_CONSUMO.length; i++){
            if (LETRAS_CONSUMO[i] == letra){
                return true;
            }
        }
        return false;
    }

    private boolean comprovarColor(String color){
        for (int i = 0; i< COLORES.length; i++){
            if (COLORES[i].equalsIgnoreCase(color)){
                return true;
            }
        }
        return false;
    }

    protected double precioFinal(){
        HashMap <Character,Integer> letraPrecio = new HashMap <>();
        letraPrecio.put('A',100);
        letraPrecio.put('B',80);
        letraPrecio.put('C',60);
        letraPrecio.put('D',50);
        letraPrecio.put('E',30);
        letraPrecio.put('F',10);
        precio += letraPrecio.get(this.consumo);

        if (this.peso >=0 && this.peso <=19){
            this.precio += 10;
        }
        else if (this.peso >=20 && this.peso <=49){
            this.precio += 50;
        }
        else if (this.peso >49 && this.peso <=79){
            this.precio += 80;
        }
        else if (this.peso >79){
            this.precio += 100;
        }
        return this.precio;
    }
}

