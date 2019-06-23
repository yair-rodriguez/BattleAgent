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
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentSendTwo extends Agent {
    
    protected void setup() {
        BattleAgent rc = new BattleAgent();
        rc.createBattle2();
        addBehaviour(new TickerBehaviour(this, 10000){
            @Override
            protected void onTick(){
                /* ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);
                mensaje.setContent(String.valueOf(ChangingButton2.coordenada));
                mensaje.addReceiver(new AID("j2",AID.ISLOCALNAME));
                send(mensaje); */
                ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);
                //Se envía el entorno del agente JADE y ACC del jugador2
                AID r = new AID("j2@192.168.43.233:1099/JADE", AID.ISGUID);
                r.addAddresses("http://192.168.43.233:7778/acc"); 
                mensaje.addReceiver(r);
                mensaje.setContent(String.valueOf(ChangingButton2.coordenada));
                send(mensaje);
                System.out.println(mensaje);
            }
        });
        /*addBehaviour(new OneShotBehaviour(this) {
            @Override
            public void action() {
                ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);
                mensaje.setContent(getLocalName() + ChangingButton.coordenada);
                mensaje.addReceiver(new AID("agentreceptor",AID.ISLOCALNAME));
                send(mensaje);            }
        });*/
    }
}
