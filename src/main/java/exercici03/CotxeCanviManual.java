package exercici03;

public class CotxeCanviManual extends Cotxe{

    public CotxeCanviManual(String matricula){
        this.matricula = matricula;
        velocitat = 0;
        marxa = Marxa.PUNT_MORT;
    }

    @Override
    public void canviarMarxa(Marxa marxa) {
        this.marxa = marxa;
    }
}
