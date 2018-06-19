import java.io.IOException;
import java.util.stream.IntStream;

public class Hello {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World \uD83D\uDE80");

        final int[] ints = IntStream.range(0, 100_000_000).toArray();
        System.out.println(ints.length);
    }
}
