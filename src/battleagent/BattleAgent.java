/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleagent;

import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Edward
 */
public class BattleAgent {
    public static int[][] modelo1;
    public static int[][] modelo2;
    public static JButton button1;
    public static JButton button2;
    public static JButton button3;
    public static JButton buttonJ1;
    public static JButton buttonJ2;
    public static JButton buttonJ3;

    

    public static void createBattle(){
         Random random = new Random();
        int dim=10;
        int matrix[][] = new int[10][10];
        int primer_barco = random.nextInt(10);
        int segundo_barco = random.nextInt(10);
        int tercer_barco = random.nextInt(10);

        modelo1 = matrix;
        JFrame f = new JFrame("BattleShip ONE");
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(dim, dim));

        for(int r = 0; r < dim; r++){
            for(int c = 0; c < dim; c++){
                if(primer_barco == r && segundo_barco == c)
                { 
                    button1 = new ChangingButton(r, c, matrix,"1erBarco");
                    p.add(button1);
                }else{
                    if(segundo_barco == r && tercer_barco == c)
                    {
                        button2 = new ChangingButton(r, c, matrix, "2doBarco");
                        p.add(button2);
                    }else{
                         if(tercer_barco == r && primer_barco == c)
                        {
                            button3 = new ChangingButton(r, c, matrix, "3erBarco");
                            p.add(button3);
                        }else{
                            ChangingButton button = new ChangingButton(r, c, matrix, "Libre");
                            p.add(button);
                        }
                     }
                }
            }
        }
        f.add(p);
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
    
    /*public static void createBattle2(){
         Random random = new Random();
        int dim=10;
        int matrix[][] = new int[10][10];
        int primer_barco = random.nextInt(10);
        int segundo_barco = random.nextInt(10);
        int tercer_barco = random.nextInt(10);
        modelo2 = matrix;
        JFrame f = new JFrame("BattleShip TWO");
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(dim, dim));

        for(int r = 0; r < dim; r++){
            for(int c = 0; c < dim; c++){
                if(primer_barco == r && segundo_barco == c)
                { 
                    buttonJ1= new ChangingButton2(r, c, matrix,"1erBarco");
                    p.add(buttonJ1);
                }else{
                    if(segundo_barco == r && tercer_barco == c)
                    {
                        buttonJ2 = new ChangingButton2(r, c, matrix, "2doBarco");
                        p.add(buttonJ2);
                    }else{
                         if(tercer_barco == r && primer_barco == c)
                        {
                            buttonJ3 = new ChangingButton2(r, c, matrix, "3erBarco");
                            p.add(buttonJ3);
                        }else{
                            ChangingButton2 button = new ChangingButton2(r, c, matrix, "Libre");
                            p.add(button);
                        }
                     }
                }
            }
        }
        f.add(p);
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        createBattle();
        //createBattle2();
    } 
}
