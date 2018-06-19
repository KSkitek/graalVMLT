package pl.ks.graal;

import org.rosuda.REngine.Rserve.RserveException;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws RserveException {
        final Random rand = new Random(System.currentTimeMillis());

//        final Calculator rserve = RServeCalculator.initialize();
        final Calculator fastR = FastRCalculator.initialize();

        final double[] a = rand.doubles().limit(1000L).toArray();
        final double[] b = rand.doubles().limit(1000L).toArray();

//        rserve.add(a, b);
        fastR.add(a, b);
    }
}
