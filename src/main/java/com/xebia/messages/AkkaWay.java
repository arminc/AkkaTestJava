package com.xebia.messages;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.xebia.messages.akka.Calculate;
import com.xebia.messages.akka.Master;

public class AkkaWay {

    public static void main(String[] args) {
        new AkkaWay().run();
    }

    private void run() {
        ActorSystem system = ActorSystem.create("CalcSystem");
        ActorRef master = system.actorOf(Master.createMaster(), "master");
        master.tell(new Calculate(), ActorRef.noSender());
    }
}
