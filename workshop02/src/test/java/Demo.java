import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Demo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,2,3,4);
        Set<Integer> tmp = new HashSet<>();
        // Find duplicated values = 2, 3
        Set<Integer> results = numbers
                .stream()
                .filter(n -> !tmp.add(n))
                .collect(Collectors.toSet());
        results.forEach(out::println);
    }
}
