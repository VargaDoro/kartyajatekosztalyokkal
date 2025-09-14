package huszonegybuvesztrukk;

import java.util.Scanner;

public class HuszonegyBuvesztrukk {

    static String[] pakli = new String[22];
    static Scanner sc = new Scanner(System.in);
    private static int oszlopSzam;

    public static void main(String[] args) {
        indit();
    }

    private static void indit() {
        feltolt();
        for (int i = 0; i < 3; i++) {
            kirak();
            beker();
            kever();
        }
        melyikVolt();
    }

    public static void feltolt() {
        String[] ertekek = {"Asz", "Kir", "Fel", "X", "IX", "VIII"};
        String[] szinek = {"P", "T", "Z", "M"};
        pakli[0] = "";
        int index = 1;
        for (int j = 0; j < ertekek.length && index < pakli.length; j++) {
            for (int k = 0; k < szinek.length && index < pakli.length; k++) {
                pakli[index] = "%s_%s".formatted(szinek[k], ertekek[j]);
                index++;
            }
        }
    }

    public static void kirak() {
        for (int i = 1; i < pakli.length; i++) {
            System.out.print("%-8s".formatted(pakli[i]));
            if (i % 3 == 0) {
                System.out.println();
            }
        }
    }

    private static void beker() {
        boolean jo;
        do {
            System.out.printf("\nMelyik oszlopban (1-3) van? : ");
            oszlopSzam = sc.nextInt();
            jo = oszlopSzam >= 1 && oszlopSzam <= 3;
        } while (!jo);
    }

    private static void kever() {
        String[] ujPakli = new String[22];
        switch (oszlopSzam) {
            case 1:
                for (int i = 1; i < 8; i++) {
                    ujPakli[i] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }
                break;
            case 2:
                for (int i = 1; i < 8; i++) {
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }
                break;
            case 3:
                for (int i = 1; i < 8; i++) {
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[21 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[20 - (i - 1) * 3];
                }
                break;
        }
        pakli = ujPakli;
    }

    private static void melyikVolt() {
        System.out.println("\nA választott kártya a(z) %s volt!".formatted(pakli[11]));
    }
}