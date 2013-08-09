package com.xebia.messages.akka;

import akka.actor.Props;
import akka.actor.UntypedActor;
import com.xebia.messages.hash.CalculateHash;
import scala.collection.mutable.ArraySeq;

public class Worker extends UntypedActor {

    @Override
    public void onReceive(Object message) {
        if (message instanceof Work) {
            new CalculateHash().calculate("something");
            getSender().tell(new Result(), getSelf());
        } else
            unhandled(message);
    }

    public static Props createWorker() {
        return Props.create(Worker.class, new ArraySeq<Object>(0));
    }
}
