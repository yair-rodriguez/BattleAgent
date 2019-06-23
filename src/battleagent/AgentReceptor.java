/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleagent;

/**
 *
 * @author Edward
 */
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Arrays;
import javax.swing.JButton;
public class AgentReceptor extends Agent {
    private final int[][] fModel = ChangingButton2.modelo;

    public String mensajeReceive = "";
     @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage mensaje = receive();
                if(mensaje != null)
                {

                    mensajeReceive = mensaje.getContent();
                    //System.out.println(String.valueOf(ChangingButton.positionx));

                    if("1".equals(String.valueOf(BattleAgent.modelo2[ChangingButton.positionx][ChangingButton.positiony])))
                    {
                        System.out.println("Eliminado Barco 1");
                        BattleAgent.buttonJ1.setText("ELIMINADO1");
                        BattleAgent.button1.setText("ELIMINADO");

                       BattleAgent.modelo2[ChangingButton.positionx][ChangingButton.positiony] = 0;
                    }else{
                        if("2".equals(String.valueOf(BattleAgent.modelo2[ChangingButton.positionx][ChangingButton.positiony])))
                        {
                            System.out.println("Eliminado Barco 2");
                              BattleAgent.buttonJ2.setText("ELIMINADO1");
                        BattleAgent.button2.setText("ELIMINADO");
                            BattleAgent.modelo2[ChangingButton.positionx][ChangingButton.positiony] = 0;
                        }else{
                            if("3".equals(String.valueOf(BattleAgent.modelo2[ChangingButton.positionx][ChangingButton.positiony])))
                            {
                                System.out.println("Eliminado Barco 3");
                                BattleAgent.buttonJ3.setText("ELIMINADO1");
                                BattleAgent.button3.setText("ELIMINADO");
                                BattleAgent.modelo2[ChangingButton.positionx][ChangingButton.positiony] = 0;

                            }
                        }
                    }
                    //rc.receptorArea.append(mensajeReceive + '\n');
                }else{
                    block();
                }
            }
        });
    }
}
