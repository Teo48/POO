package com.oop_pub.exceptions.ex2_3;

import java.util.Collection;

public class Calculator {
    Double add(Double i1, Double i2) throws NullParameterException, OverflowException, UnderflowException {
        if (i1 == null || i2 == null) {
            throw new NullParameterException("Null parameter");
        }

        if (i1 + i2 >= Double.POSITIVE_INFINITY) {
            throw new OverflowException("Overflow exception!");
        } else if (i1 - i2 <= Double.NEGATIVE_INFINITY) {
            throw new UnderflowException("Underflow exception!");
        }

        return i1 + i2;
    }

    Double  divide(Double  i1, Double  i2) {
        if (i1 == null || i2 == null) {
            throw new NullParameterException("Null parameter");
        }

        return i1 / i2;
    }

    Double  average(Collection<Double> ints) {
        if (ints == null) {
            throw new NullParameterException("Null parameter");
        }
        Double  avg = 0d;

        for (Double  num : ints) {
            avg = add(avg, num);
        }

        return divide(avg, ints.size() * 1d);
    }
}
