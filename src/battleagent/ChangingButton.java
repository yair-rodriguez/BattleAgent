/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleagent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Edward
 */
public class ChangingButton extends JButton {

    private final int[][] fModel;
    private final int fX;
    private final int fY;
    private final String fNombre;
    public static int coordenada;
    public static int[][] modelo;
    public static int positionx;
    public static int positiony;
    public static String barco;
    public static ActionEvent eventobutton;



    public ChangingButton(final int x, final int y, final int[][] model, final String nombre) {
        fX= x;
        fY= y;
        fModel= model;
        fNombre = nombre;
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coordenada = fModel[fX][fY];
                barco = ((JButton) e.getSource()).getText();
                eventobutton = e;
                //coordenada = fX + " " + fY;
                modelo = fModel;
                positionx = fX;
                positiony = fY;
                /*AgenteSend agent = new AgenteSend();
                agent.getData(coordenada);*/
                //System.out.println(fX + " " + fY);
                updateNameFromModel();
            }
        });
        updateNameFromModel();
    }

    public final void updateNameFromModel() {
        if("1erBarco".equals(fNombre))
        {
            fModel[fX][fY] = 1;
        }else{
            if("2doBarco".equals(fNombre))
            {
                fModel[fX][fY] = 2;
            }else{
                if("3erBarco".equals(fNombre))
                {
                    fModel[fX][fY] = 3;
                }else{
                    fModel[fX][fY] = 0;
                }
            }
        }
        setText(fNombre);
    }

}