package modell;

import java.util.Arrays;
import java.util.Scanner;

public class Pakli{
    
    static Scanner sc = new Scanner(System.in); 
    private Lap[] pakli;
    
    public Pakli(){
        pakli = new Lap[22];
    }
    
    public Lap getLap(int index){
        return pakli[index];
    }  
  
    public void feltolt(){
        String[] ertekek = {"Asz", "Kir", "Fel", "X", "IX", "VIII"};
        String[] szinek = {"P", "T", "Z", "M"};
        pakli[0] = new Lap("");
        int index = 1;
        for (int j = 0; j < ertekek.length && index < pakli.length; j++){
            for (int k = 0; k < szinek.length && index < pakli.length; k++){
                pakli[index] = new Lap("%s_%s".formatted(szinek[k], ertekek[j]));
                index++;
            }
        }
    }    
    
    public String kirak(){
        String s = "";
        for (int i = 1; i < pakli.length; i++){
            s += String.format("%-25s".formatted(pakli[i].getLeiras()));
            if (i % 3 == 0){
                s += System.lineSeparator();
            }
        }
        return s;
    }
    
    public void kever(int oszlopSzam){
        Lap[] ujPakli = new Lap[22];
        switch (oszlopSzam){
            case 1:
                for (int i = 1; i < 8; i++){
                    ujPakli[i] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }break;
            case 2:
                for (int i = 1; i < 8; i++){
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }break;
            case 3:
                for (int i = 1; i < 8; i++){
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[21 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[20 - (i - 1) * 3];
                }break;
        }
        pakli = ujPakli;
    }

    public Lap ezVolt(){
        return pakli[11];
    }
}
