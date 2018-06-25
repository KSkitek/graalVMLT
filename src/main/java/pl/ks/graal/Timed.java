package pl.ks.graal;

public class Timed implements Calculator {
    private final Calculator delegate;

    public Timed(Calculator delegate) {
        this.delegate = delegate;
    }

    @Override
    public double[] add(double[] a, double[] b) {
        final long begin = System.currentTimeMillis();
        final double[] result = delegate.add(a, b);
        final long end = System.currentTimeMillis();
        System.out.println(delegate.getClass().getSimpleName() + ": " + (end - begin));

        return result;
    }
}
