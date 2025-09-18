package nezet;

import modell.Pakli;
import java.util.Scanner;

public class KartyaTrukk_CUI 
{
    private static Scanner sc = new Scanner(System.in);
    private static final String SEP = System.lineSeparator();
    private Pakli pakli;
    
    public KartyaTrukk_CUI(){
        pakli = new Pakli();
        indit();
    }
    
    
    public void indit(){
        this.pakli.feltolt();
        
        for (int i = 0; i < 3; i++){
            String s = pakli.kirak();
            konzolraIr(s+SEP);
            int oszlop = melyik();
            this.pakli.kever(oszlop);
        }
        melyikVolt();
        konzolraIr("A választott lap: ");
        konzolraIr(pakli.ezVolt().getLeiras());
        konzolraIr(SEP);
        
    }  

    private int melyik(){
        int oszlopSzam;
        boolean jo;
        do {
            System.out.printf("\nMelyik oszlopban (1-3) van? : ");
            oszlopSzam = sc.nextInt();
            jo = oszlopSzam >= 1 && oszlopSzam <= 3;
        } while (!jo);
        return oszlopSzam;
    }

    private void konzolraIr(String msg){
        System.out.print(msg);
    }

    private void oszlopok(){
        String s = "";
        for (int i = 0; i <= 3; i++) {
            s += String.format("%-7s", i+".");
        }
        konzolraIr(s+SEP);
    }
    
    private void melyikVolt(){
        System.out.println("\nA választott kártya a(z) %s volt!".formatted(pakli.getLap(11).getLeiras()));
    }
}