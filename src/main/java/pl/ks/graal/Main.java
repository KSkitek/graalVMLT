package pl.ks.graal;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        final Context context = Context.newBuilder("R")
                .in(System.in)
                .out(System.out)
                .err(System.err)
                .allowAllAccess(true)
                .build();
        context.getEngine().getInstruments().keySet().forEach(System.out::println);

        try {
            context.eval("R", "str(c(0:1))");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        final InputStream testIS = Main.class.getResourceAsStream("test.R");
        final BufferedReader br = new BufferedReader(new InputStreamReader(testIS));
        String line = br.readLine();
        final StringBuilder sb = new StringBuilder();
        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        br.close();

        IntStream.range(1, 10).forEach(i -> {});
        for (int i = 0; i < 10; i++) {
            final Value eval = context.eval(Source.newBuilder("R", sb.toString(), "testIS").build());
            System.out.println(eval);
        }
    }
}
