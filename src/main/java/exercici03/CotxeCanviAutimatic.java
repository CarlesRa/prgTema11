package exercici03;

public class CotxeCanviAutimatic extends Cotxe{

    public CotxeCanviAutimatic(String matricula){
        this.matricula = matricula;
        velocitat = 0;
        marxa = Marxa.PUNTO_MUERTO;
    }

    @Override
    public void accelerar(double acceleracio){
        if (acceleracio>=0){
            this.velocitat += acceleracio;
        }
        else{
            System.out.println("No se puede acelerar en negativo");
        }
        if (this.velocitat >0 && this.velocitat <= 20){
            marxa = Marxa.PRIMERA;
        }
        else if (this.velocitat > 20 && this.velocitat <=40){
            marxa = Marxa.SEGONA;
        }
        else if (this.velocitat > 40 && this.velocitat <=80){
            marxa = Marxa.TERCERA;
        }
        else if (this.velocitat > 80 && this.velocitat <=100){
            marxa = Marxa.CUARTA;
        }
        else if (this.velocitat > 100){
            marxa = Marxa.QUINTA;
        }
    }

    @Override
    public void frenar(double frenar){
        if (frenar>=0 && (this.velocitat -= frenar) >= 0){
            this.velocitat -= frenar;
        }
        else{
            System.out.println("No se puede frenar a menos de 0.");
        }
        if (this.velocitat >0 && this.velocitat <= 20){
            marxa = Marxa.PRIMERA;
        }
        else if (this.velocitat > 20 && this.velocitat <=40){
            marxa = Marxa.SEGONA;
        }
        else if (this.velocitat > 40 && this.velocitat <=80){
            marxa = Marxa.TERCERA;
        }
        else if (this.velocitat > 80 && this.velocitat <=100){
            marxa = Marxa.CUARTA;
        }
        else if (this.velocitat > 100) {
            marxa = Marxa.QUINTA;
        }
    }
}
