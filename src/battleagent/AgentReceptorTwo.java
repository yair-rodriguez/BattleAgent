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
import battleagent.BattleAgent;
public class AgentReceptorTwo extends Agent {
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
                     /*if(String.valueOf(BattleAgent.modelo1[ChangingButton22.positionx][ChangingButton22.positiony]).equals(mensajeReceive))
                    {
                       ChangingButton2 button= new ChangingButton2(ChangingButton22.positionx, ChangingButton22.positiony, BattleAgent.modelo1,"ELIMINADO"); 
                      button.updateNameFromModel();
                    }*/
                    if("1".equals(String.valueOf(BattleAgent.modelo1[ChangingButton2.positionx][ChangingButton2.positiony])))
                    {
                        System.out.println("Eliminado Barco 1");
                        BattleAgent.button1.setText("ELIMINADO");
                        //ChangingButton2 button= new ChangingButton2(ChangingButton2.positionx, ChangingButton2.positiony, BattleAgent.modelo2,"ELIMINADO"); 
                        //button.updateNameFromModel();

                       BattleAgent.modelo1[ChangingButton2.positionx][ChangingButton2.positiony] = 0;
                    }else{
                        if("2".equals(String.valueOf(BattleAgent.modelo1[ChangingButton2.positionx][ChangingButton2.positiony])))
                        {
                            System.out.println("Eliminado Barco 2");
                              BattleAgent.buttonJ2.setText("ELIMINADO1");
                        BattleAgent.button2.setText("ELIMINADO");
                            BattleAgent.modelo1[ChangingButton2.positionx][ChangingButton2.positiony] = 0;
                        }else{
                            if("3".equals(String.valueOf(BattleAgent.modelo1[ChangingButton2.positionx][ChangingButton2.positiony])))
                            {
                                System.out.println("Eliminado Barco 3");
                                BattleAgent.buttonJ3.setText("ELIMINADO1");
                                BattleAgent.button3.setText("ELIMINADO");
                                BattleAgent.modelo1[ChangingButton2.positionx][ChangingButton2.positiony] = 0;

                            }
                        }
                    }
                    //System.out.println(mensajeReceive);
                    //rc.receptorArea.append(mensajeReceive + '\n');
                }else{
                    block();
                }
            }
        });
    }
}
