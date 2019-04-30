/*
 * Copyright (c) Carles Ramos
 */

package exercici07;


public class Estadi {
    private Zona [] zones;

    public Estadi(int zonesNormals, int zonesVip) {
        zones = new Zona[zonesNormals + zonesVip];
    }

    public void addZona(int posicio, Zona zona){
        zones [posicio] = zona;
    }

    public Zona[] getZones() {
        return zones;
    }

    public void mostrarEstadi(){
        for (int i=0; i<zones.length; i++){
            if (zones[i] instanceof ZonaNormal) {
                System.out.println("Zona normal: " + i);
                zones[i].mostrarZonas();
            }

            else{
                System.out.println("Zona VIP: " + i);
                zones[i].mostrarZonas();
            }
        }
    }
}
