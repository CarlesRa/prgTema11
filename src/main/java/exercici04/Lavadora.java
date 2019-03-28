/*
 * Copyright (c) Carles Ramos
 */

package exercici04;

public class Lavadora extends Electrodomestico {
    private static final float cargaPorDefecto = 5;
    private float carga;

    public Lavadora() {
        super();
        this.carga = cargaPorDefecto;
        this.precio += precioFinal();
    }

    public Lavadora(double precio, float peso) {
        super(precio, peso);
        this.precio += precioFinal();
        this.carga = cargaPorDefecto;

    }

    public Lavadora(double precio, String color, char consumo, float peso, float carga) {
        super(precio, color, consumo, peso);
        this.precio += precioFinal();
        this.carga = carga;
    }

    @Override
    public double precioFinal(){
        if (this.carga > 30){
            this.precio += 50;
        }
        return this.precio;
    }

    public float getCarga() {
        return carga;
    }
}

