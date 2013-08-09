package com.xebia.messages;

import com.xebia.messages.hash.CalculateHash;
import com.xebia.messages.time.Time;

public class JavaWay {

    private final long messages = 100000000;
    CalculateHash hash = new CalculateHash();
    Time time = new Time();

    public static void main(String[] array) {
        new JavaWay().run();
    }

    private void run() {
        time.start();
        calculateHash();
        time.end();
        printElapsedTime(time);
    }

    private void calculateHash() {
        for (int i = 0; i < messages; i++) {
            hash.calculate("something");
        }
    }

    private void printElapsedTime(Time time) {
        System.out.println(time.elapsedTimeMilliseconds());
    }
}
