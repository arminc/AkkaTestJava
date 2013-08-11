package com.xebia.messages.hash;

import java.math.BigInteger;

public class CalculateFactorial {

    public BigInteger calculate() {
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i <= 739; i++)
            fact = fact.multiply(BigInteger.valueOf(i));
        return fact;
    }
}
