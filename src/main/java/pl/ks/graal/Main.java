package pl.ks.graal;

import org.rosuda.REngine.Rserve.RserveException;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws RserveException {
        final Random rand = new Random(System.currentTimeMillis());

        final double[] a = rand.doubles().limit(100000L).toArray();
        final double[] b = rand.doubles().limit(100000L).toArray();

        final Calculator rserve = new Repeated(new Timed(RServeCalculator.initialize()), 5);
        final Calculator fastR = new Repeated(new Timed(FastRCalculator.initialize()), 5);

        fastR.add(a, b);
        rserve.add(a, b);
    }
}
