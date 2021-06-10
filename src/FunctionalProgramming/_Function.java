package FunctionalProgramming;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int incrementByMethod = 1;
        System.out.println(incrementByTwo(incrementByMethod));

        int incrementByFunctionalProgramming = incrementByTwoFunction.apply(1);
        System.out.println(incrementByFunctionalProgramming);
    }

    static Function<Integer, Integer> incrementByTwoFunction = number -> number + 2;

    static int incrementByTwo(int number) {
        return number + 2;
    }
}
