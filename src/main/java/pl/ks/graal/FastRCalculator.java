package pl.ks.graal;

import org.graalvm.polyglot.Context;

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
        context.asValue(a);
        context.asValue(b);
        return context.eval("R", "a + b").as(double[].class);
    }
}
