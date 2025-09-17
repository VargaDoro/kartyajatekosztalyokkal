package huszonegybuvesztrukk;

import java.util.Scanner;

public class KartyaTrukk 
{
    private static Scanner sc = new Scanner(System.in);
    private Pakli pakli;
    
    public void indit() 
    {
        this.pakli.feltolt();
        
        for (int i = 0; i < 3; i++) 
        {
            this.pakli.kirak();
            int oszlop = melyik();
            this.pakli.kever(oszlop);
        }
        melyikVolt();
        
    }  

    private int melyik() 
    {
        int oszlopSzam;
        boolean jo;
        do {
            System.out.printf("\nMelyik oszlopban (1-3) van? : ");
            oszlopSzam = sc.nextInt();
            jo = oszlopSzam >= 1 && oszlopSzam <= 3;
        } while (!jo);
        return oszlopSzam;
    }


    private void melyikVolt() {
        System.out.println("\nA választott kártya a(z) %s volt!".formatted(pakli.getLap(11).getLeiras()));
    }
}