package pl.ks.graal;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RServeCalculator implements Calculator {
    private final RConnection conn;

    private RServeCalculator(RConnection conn) {
        this.conn = conn;
    }

    public static Calculator initialize() throws RserveException {
//        final String address = "localhost";
        final String address = "46.101.212.137";
        final RConnection conn = new RConnection(address, 6311);
        return new RServeCalculator(conn);
    }

    private double[] rexpToArray(REXP result) {
        return new double[0];
    }

    @Override
    public double[] add(double[] a, double[] b) {
        try {
            conn.assign("a", a);
            conn.assign("b", b);
            return conn.eval("a + b").asDoubles();

        } catch (REngineException | REXPMismatchException e) {
            e.printStackTrace();
            return new double[0];
        }
    }
}
