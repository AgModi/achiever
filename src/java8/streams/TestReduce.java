package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestReduce {
    public static void main(String[] args) {
        testReduce();
    }

    private static void testReduce() {
        List<Integer> list = Arrays.asList(1,2,3,8,4,5,6);
        Optional<Integer> optlist = list.stream().reduce((m, n) -> (m<n)? n : m);
        if (optlist.isPresent()){
            System.out.println(optlist.get());
        } else {
            System.out.println("Nohthing in reslt");
        }
    }
}
