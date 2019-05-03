/*
 * Copyright (c) Carles Ramos
 */

package exercici07;


public class Grada {
    private Zona [] zones;
    private int entradesTotals;
    public Grada(int zonesNormals, int zonesVip, int entradesTotals) {
        zones = new Zona[zonesNormals + zonesVip];
        this.entradesTotals = entradesTotals;
    }

    public void addZona(int posicio, Zona zona){
        zones [posicio] = zona;
    }

    public Zona[] getZones() {
        return zones;
    }

    public int getEntradesTotals() {
        return entradesTotals;
    }

    public void mostarGrada(){
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

    public void mostrarZonesVip(){
        for (int i=0; i<zones.length; i++){
            if (zones[i] instanceof ZonaVip) {
                System.out.println("Zona VIP: " + i);
                zones[i].mostrarZonas();
            }
        }
    }

    public void mostrarZonesNormals(){
        for (int i=0; i<zones.length; i++){
            if (zones[i] instanceof ZonaNormal) {
                System.out.println("Zona Normal: " + i);
                zones[i].mostrarZonas();
            }
        }
    }

}
