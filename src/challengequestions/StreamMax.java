package challengequestions;

import java.util.*;
import java.util.stream.Stream;

public class StreamMax {
    public static void main(String args[]) throws Exception {
        List<Integer> ints = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        System.out.println(maxVal(ints));
    }

    public static int maxVal(List<Integer> ints) {
        OptionalInt res = ints.stream()
            .mapToInt(Integer::valueOf)
            .max();
        if (res.isPresent()) return res.getAsInt();
        throw new RuntimeException();
        // ideally exception handling of optionalInt here with an isPresent
    }


}