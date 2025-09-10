package huszonegybuvesztrukk;

public class HuszonegyBuvesztrukk {

    static String[] pakli = new String[21];

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

    public static void main(String[] args) {
        feltolt();
        kirak();
    }
}
