package com.xebia.messages;

import com.xebia.messages.hash.CalculateFactorial;
import com.xebia.messages.time.Time;

import java.util.ArrayList;

public class JavaWay {

    private final long messages = 1000000;
    ArrayList list = new ArrayList();
    Time time = new Time();

    public static void main(String[] array) {
        new JavaWay().run();
    }

    private void run() {
        time.start();
        calculateFactorial();
        time.end();
        printElapsedTime(time);
    }

    private void calculateFactorial() {
        for (int i = 0; i < messages; i++) {
            list.add(new CalculateFactorial().calculate());
        }
    }

    private void printElapsedTime(Time time) {
        System.out.println("Done: " + time.elapsedTimeMilliseconds());
    }
}
