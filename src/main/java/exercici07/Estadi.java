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
}
