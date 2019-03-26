package exercici03;

import utils.Lib;

import java.util.Scanner;

public class Exercici03 {
    private Cotxe cotxe;
    private Scanner lec;
    private String matricula;
    private int eleccio;
    private boolean esCorrecte;
    private String clase;
    public Exercici03(){
        lec = new Scanner(System.in);
        esCorrecte = false;
        matricula = "";
        eleccio = 0;
        clase = "";
        do {
            System.out.print("Indique la matrícula del vehicle: ");
            matricula = lec.nextLine();
            if (matricula.length() != 8 || matricula.charAt(4) != ' '){
                System.out.println("Matricula incorrecta...");
                Lib.continuar();
                esCorrecte = false;
            }
            else {
                esCorrecte = true;
            }
        }while (!esCorrecte);
        do {
            System.out.println("1-Cotxe automatic");
            System.out.println("2-Cotxe manual");
            System.out.print("Tria una opció: ");
            try{
                eleccio = Integer.parseInt(lec.nextLine());
                if (eleccio < 1 || eleccio > 2){
                    System.out.println("Dada incorrecta...");
                    Lib.continuar();
                    esCorrecte = false;
                }
                else{
                    esCorrecte = true;
                }
            }
            catch (NumberFormatException nfe){
                System.out.println("Dada incorrecta.... no es poden introduir lletres");
                Lib.continuar();
                esCorrecte = false;
            }
        }while (!esCorrecte);
        if (eleccio == 1){
            cotxe = new CotxeCanviAutimatic(matricula);
        }
        else if (eleccio == 2){
            cotxe = new CotxeCanviManual(matricula);
        }

        System.out.println(cotxe.toString());

        cotxe.accelerar(60);

        if (cotxe instanceof CotxeCanviManual){
            cotxe.canviarMarxa(Marxa.TERCERA);
        }

        System.out.println(cotxe.toString());
    }
}
