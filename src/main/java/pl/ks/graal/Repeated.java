package pl.ks.graal;

public class Repeated implements Calculator {
    private final Calculator delegate;
    private final long repetitions;

    public Repeated(Calculator delegate, long repetitions) {
        this.delegate = delegate;
        this.repetitions = repetitions;
    }

    @Override
    public double[] add(double[] a, double[] b) {
        double[] lastResult = new double[0];

        for (int i = 0; i < repetitions; i++)
            lastResult = delegate.add(a, b);

        return lastResult;
    }
}
