package exercici03;

public enum Marxa {
    PUNTO_MUERTO(0),PRIMERA(1),SEGONA(2),TERCERA(3),CUARTA(4);
    private int i;
    Marxa(int i) {
        this.i = i;
    }
    public  int getI(){
        return i;
    }

    @Override
    public String toString() {
        return "Marxa: "+
                + i;
    }
}
