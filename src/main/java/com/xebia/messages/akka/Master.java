package com.xebia.messages.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RoundRobinRouter;
import com.xebia.messages.time.Time;
import scala.collection.mutable.ArraySeq;

public class Master extends UntypedActor {

    private long messages = 100000000;
    private long processed = 0;
    private ActorRef workerRouter;
    private final Time time = new Time();

    public Master() {
        workerRouter = this.getContext().actorOf(Worker.createWorker().withRouter(new RoundRobinRouter(4)), "workerRouter");
        time.start();
    }

    @Override
    public void onReceive(Object message) {
        if (message instanceof Calculate) {
            for (int i = 0; i < messages; i++) {
                workerRouter.tell(new Work(), getSelf());
            }
        } else if (message instanceof Result) {
            processed++;
            if (processed == messages) {
                time.end();
                System.out.println("Done: " + time.elapsedTimeMilliseconds());
                getContext().system().shutdown();
            }
        } else {
            unhandled(message);
        }
    }

    public static Props createMaster() {
        return Props.create(Master.class, new ArraySeq<Object>(0));
    }
}
