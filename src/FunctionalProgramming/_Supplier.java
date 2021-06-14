package FunctionalProgramming;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getJdbcUrl.get());
    }

    private static Supplier<List<String>> getJdbcUrl = () ->
            List.of("jdbc://localhost:5432/users");
}
