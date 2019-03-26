package exercici03;

public abstract class Cotxe {
    protected String matricula;
    protected double velocitat;
    protected Marxa marxa;

    public Cotxe(String matricula) {
        this.matricula = matricula;
        velocitat = 0;
        marxa=Marxa.PUNTO_MUERTO;
    }

    public Cotxe() {
        matricula = "";
        velocitat = 0;
        marxa = Marxa.PUNTO_MUERTO;
    }

    public double getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(double velocitat) {
        this.velocitat = velocitat;
    }

    public Marxa getMarxa() {
        return marxa;
    }

    public void setMarxa(Marxa marxa) {
        this.marxa = marxa;
    }

    protected void accelerar(double acceleracio){
        if (acceleracio>=0){
            this.velocitat += acceleracio;
        }
        else{
            System.out.println("No se puede acelerar en negativo");
        }
    }

    protected void frenar(double frenar){
        if (frenar>=0 && (this.velocitat -= frenar) >= 0){
            this.velocitat -= frenar;
        }
        else{
            System.out.println("No se puede frenar a menos de 0.");
        }
    }

    void canviarMarxa(Marxa marxa){
        this.marxa = marxa;
    }

    @Override
    public String toString() {
        return "Cotxe{" +
                "matricula='" + matricula + '\'' +
                ", velocitat=" + velocitat +
                ", marxa=" + marxa +
                '}';
    }
}
