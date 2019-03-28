/*
 * Copyright (c) Carles Ramos
 */

package exercici04;

public class Lavadora extends Electrodomestico {
    private static final float CARGA_POR_DEFECTO = 5;
    private float carga;

    public Lavadora() {
        this(PRECIO_BASE,COLOR_POR_DEFECTO,LETRA_POR_DEFECTO,PESO_PREDETERMINADO, CARGA_POR_DEFECTO);
    }

    public Lavadora(double precio, float peso) {
        this(precio,COLOR_POR_DEFECTO,LETRA_POR_DEFECTO,peso, CARGA_POR_DEFECTO);

    }

    public Lavadora(double precio, String color, char consumo, float peso, float carga) {
        super(precio, color, consumo, peso);
        this.carga = carga;
    }

    @Override
    public double precioFinal(){
        super.precioFinal();
        if (this.carga > 30){
            this.precio += 50;
        }
        return this.precio;
    }

    public float getCarga() {
        return carga;
    }
}

