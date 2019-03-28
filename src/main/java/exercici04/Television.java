/*
 * Copyright (c) Carles Ramos
 */

package exercici04;

public class Television extends Electrodomestico{
    private float resolucion;
    private boolean esSmart;

    public Television() {
        super();
        this.resolucion = 20;
        this.esSmart = false;
    }

    public Television(double precio, float peso) {
        super(precio, peso);
        this.precio += precioFinal();
        this.resolucion = 20;
        this.esSmart = false;
    }

    public Television(double precio, String color, char consumo, float peso, float resolucion, boolean esSmart) {
        super(precio, color, consumo, peso);
        this.resolucion = resolucion;
        this.esSmart = esSmart;
    }

    public float getResolucion() {
        return resolucion;
    }

    public boolean isEsSmart() {
        return esSmart;
    }
    @Override
    public double precioFinal(){
        if (this.resolucion > 40){
            this.precio += this.precio*0.3;
        }
        if (this.esSmart){
            this.precio += 50;
        }
        return this.precio;
    }
}
