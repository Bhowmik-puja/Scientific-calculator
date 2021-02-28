package com.example.scientificcalculator;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;

import java.util.Iterator;

class ExtendedDoubleEvaluator extends DoubleEvaluator {
    /** Defines the new function (square root).*/
    private static final Function SQRT = new Function("sqrt", 1);
    private static final Function CBRT = new Function("cbrt", 1);
    private static final Parameters PARAMS;

    static {
        // Gets the default DoubleEvaluator's parameters
        PARAMS = DoubleEvaluator.getDefaultParameters();
        // add the new sqrt function to these parameters
        PARAMS.add(SQRT);
        PARAMS.add(CBRT);
    }

    public ExtendedDoubleEvaluator() {
        super(PARAMS);
    }

    @Override
    protected Double evaluate(Function function, Iterator<Double> arguments, Object evaluationContext) {
        if (function == SQRT) {
            // Implements the new function
            return Math.sqrt(arguments.next());
        }
        else if(function == CBRT)
        {
            return Math.cbrt(arguments.next());
        }

        else {
            // If it's another function, pass it to DoubleEvaluator
            return super.evaluate(function, arguments, evaluationContext);
        }
    }

}