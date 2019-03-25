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

    protected void acelerar(double acceleracio){
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
            System.out.println("No se puedde frenar a menos de 0.");
        }
    }

    protected abstract void canviarMarxa(Marxa marxa);

    @Override
    public String toString() {
        return "Cotxe{" +
                "matricula='" + matricula + '\'' +
                ", velocitat=" + velocitat +
                ", marxa=" + marxa +
                '}';
    }


}
