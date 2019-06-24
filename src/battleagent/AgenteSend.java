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

public class AgenteSend extends Agent {
    
    protected void setup() {
        BattleAgent rc = new BattleAgent();
        rc.createBattle();
        addBehaviour(new TickerBehaviour(this, 2000){
            @Override
            protected void onTick(){
                //System.out.println("Me imprimi");
                ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);
                AID r = new AID("j1@192.168.0.17:1099/JADE",AID.ISGUID);
                r.addAddresses("http://192.168.0.17:7778/acc");
                mensaje.addReceiver(r);
                mensaje.setContent(ChangingButton.positionx  + ","  + ChangingButton.positiony);
                send(mensaje);
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
