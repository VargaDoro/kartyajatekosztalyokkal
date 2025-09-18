package nezet;

import modell.Pakli;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class KartyaTrukk_JOP{
    private static Scanner sc = new Scanner(System.in);
    private static final String SEP = System.lineSeparator();
    private Pakli pakli;
    private static JTextArea textArea;
    
    public KartyaTrukk_JOP(){
        pakli = new Pakli();
        indit();
    }
    
    public void indit(){
        this.pakli.feltolt();
        for (int i = 0; i <= 3; i++){
            String o = oszlopok();
            String s = pakli.kirak();
            String kerdes = "Melyik oszlopban van?(1-3): ";
            formaz(o+SEP+s+SEP+kerdes+SEP);
            String vo = felugrobanKerdez();
            pakli.kever(Integer.parseInt(vo));
        }
        String v = "A választott lap: ";
        String lap = pakli.ezVolt().getLeiras();
        felugrobaIr(v+lap+SEP);
    }  

    private int melyik(){
        int oszlopSzam;
        boolean jo;
        do {
            //felugrobaIr("\nMelyik oszlopban (1-3) van? : ");
            String s = JOptionPane.showInputDialog("\nMelyik oszlopban (1-3) van?: ");
            oszlopSzam = Integer.parseInt(s);
            jo = oszlopSzam >= 1 && oszlopSzam <= 3;
        } while (!jo);
        return oszlopSzam;
    }

    private void formaz(String msg){
        textArea = new JTextArea(msg);
        textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        textArea.setEditable(false);
        textArea.setBackground(null);
        textArea.setBorder(null);
    }
    
    private String felugrobanKerdez(){
        return JOptionPane.showInputDialog(null, textArea, "Válassz oszlopot!", JOptionPane.QUESTION_MESSAGE);
    }
    
    private void felugrobaIr(String msg){
        JOptionPane.showMessageDialog(null, msg, "Melyik oszlopban van?", JOptionPane.INFORMATION_MESSAGE);
    }

    private String oszlopok(){
        String s = "";
        for (int i = 1; i <= 3; i++) {
            s += String.format("%-7s", i+".");
        }
        return s+SEP;
    }
    
    private void melyikVolt(){
        System.out.println("\nA választott kártya a(z) %s volt!".formatted(pakli.getLap(11).getLeiras()));
    }
}