package pl.ks.graal;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class FastRCalculator implements Calculator {
    private final Context context;

    private FastRCalculator(Context context) {
        this.context = context;
    }

    public static Calculator initialize() {
        final Context context = Context.newBuilder("R")
                .in(System.in)
                .out(System.out)
                .err(System.err)
                .allowAllAccess(true)
                .build();

        return new FastRCalculator(context);
    }

    @Override
    public double[] add(double[] a, double[] b) {
//        context.asValue(a);
//        context.asValue(b);
//        ProxyArray
        final Value addFunc = context.eval("R", "function(a,b) {a + b}");
        return addFunc.execute(a, b).as(double[].class);
    }
}
