/*
 * Copyright (c) Carles Ramos
 */

package exercici04;

public class Television extends Electrodomestico{
    private float resolucion;
    private boolean esSmart;
    public static final float RESOLUCION_POR_DEFECTO = 20;
    public static final boolean SMART_POR_DEFECTO = false;

    public Television() {
        this(PESO_PREDETERMINADO,COLOR_POR_DEFECTO,LETRA_POR_DEFECTO
        ,PESO_PREDETERMINADO,RESOLUCION_POR_DEFECTO,SMART_POR_DEFECTO);
    }

    public Television(double precio, float peso) {
        this(precio,COLOR_POR_DEFECTO,LETRA_POR_DEFECTO
                ,peso,RESOLUCION_POR_DEFECTO,SMART_POR_DEFECTO);
    }


    public Television(double precio, String color, char consumo, float peso, float resolucion, boolean esSmart) {
        super(precio, color, consumo, peso);
        this.resolucion = resolucion;
        this.esSmart = esSmart;
    }

    public float getResolucion() {
        return resolucion;
    }

    public boolean isSmart() {
        return esSmart;
    }
    @Override
    public double precioFinal(){
        super.precioFinal();
        if (this.resolucion > 40){
            this.precio += (this.precio*0.3);
        }
        if (this.esSmart){
            this.precio += 50;
        }
        return this.precio;
    }
}
