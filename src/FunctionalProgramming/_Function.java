package FunctionalProgramming;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int incrementByMethod = 1;
        System.out.println(incrementByTwo(incrementByMethod));

        int incrementByFunctionalProgramming = incrementByTwoFunction.apply(1);
        System.out.println(incrementByFunctionalProgramming);

        Integer combinedResult = incrementByTwoFunction.andThen(multiplyBy20).apply(2);
        System.out.println(combinedResult);

        Function<Integer, Integer> incrementBy2AndMultiplyBy20 = incrementByTwoFunction.andThen(multiplyBy20);
        System.out.println(incrementBy2AndMultiplyBy20.apply(2));
    }

    static Function<Integer, Integer> multiplyBy20 = number -> number * 20;

    static Function<Integer, Integer> incrementByTwoFunction = number -> number + 2;

    static int incrementByTwo(int number) {
        return number + 2;
    }
}
