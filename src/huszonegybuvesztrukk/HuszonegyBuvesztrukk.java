package huszonegybuvesztrukk;

import java.util.Scanner;

public class HuszonegyBuvesztrukk {

    static String[] pakli = new String[21];
    static Scanner sc = new Scanner(System.in);
    private static int oszlopSzam;

    public static void main(String[] args) {
        indit();
    }

    private static void indit() {
        feltolt();
        for (int i = 0; i < 3; i++) 
        {
            kirak();
            beker();
            kever();
        }
        melyikVolt();
    }

    public static void feltolt() {
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertek = {"Ász", "kir", "Fel", "X", "IX", "VIII"};
        int index = 0;
        for (int i = 0; i < szinek.length && index < pakli.length; i++) {
            for (int j = 0; j < ertek.length && index < pakli.length; j++) {
                pakli[index] = szinek[i] + "_" + ertek[j];
                index++;
            }
        }
    }

    public static void kirak() {
        int sorokSzama = 7;
        int oszlopokSzama = 3;

        for (int sor = 0; sor < sorokSzama; sor++) {
            for (int oszlop = 0; oszlop < oszlopokSzama; oszlop++) {
                int index = sor + oszlop * sorokSzama;
                if (index < pakli.length && pakli[index] != null) {
                    System.out.print(pakli[index] + "\t");
                }
            }
            System.out.println();
        }
    }

    private static void beker() {
        boolean jo;
        do {
            System.out.printf("Melyik oszlopban (1-3): ");
            oszlopSzam = sc.nextInt();
            jo = oszlopSzam >= 1 && oszlopSzam <= 3;
        } while (!jo);
    }

    private static void kever() 
    {
        String[] ujPakli = new String[21];
        switch (oszlopSzam) 
        {
            case 1:
                for (int i = 1; i < 7; i++) 
                {
                    ujPakli[i] = pakli[19-(i-1)*3];
                    ujPakli[i+7] = pakli[20-(i-1)*3];
                    ujPakli[i+14] = pakli[21-(i-1)*3];
                }
                break;
            case 2:
                for (int i = 1; i < 7; i++) {
                    ujPakli[i] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }
                break;
            case 3:
                for (int i = 1; i < 7; i++) {
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[21 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[20 - (i - 1) * 3];
                }
                break;
        }
    }

    private static void melyikVolt() 
    {
        System.out.println("A választott kártya a(z) %s volt!".formatted(pakli[10]));
    }

}