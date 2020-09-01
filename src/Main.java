import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<King> kingsOfPoland = getKings();

        getFemaleKingsImperative(kingsOfPoland);  //65192700  69766900
        getFemaleKingsDeclarative(kingsOfPoland); //12944700  14753300

        System.out.println();

        areAllKingsOlderThan20Imperative(kingsOfPoland);  //31500    3042500
        areAllKingsOlderThan20Declarative(kingsOfPoland); //1997300  66420200

        System.out.println();

        anyKingOlderThan80Imperative(kingsOfPoland);   //22100   88300    25100
        anyKingOlderThan80Declarative(kingsOfPoland);  //386500  1278700  364500

        System.out.println();

        kingWithMaxAgeImperative(kingsOfPoland);    //38600       613100
        kingWithMaxAgeDeclarative(kingsOfPoland);   //36106800    37230400
    }

    private static void kingWithMaxAgeImperative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        King maxAgeKing = kingsOfPoland.get(0);
        for (King king : kingsOfPoland) {
            if (king.getAge() > maxAgeKing.getAge()) {
                maxAgeKing = king;
            }
        }
        System.out.println(maxAgeKing);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time anyKingOlderThan80Imperative: " + elapsedTime);
    }

    private static void kingWithMaxAgeDeclarative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        kingsOfPoland.stream()
                .max(Comparator.comparing(King::getAge))
                .ifPresent(king -> System.out.println(king));
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time kingWithMaxAgeDeclarative: " + elapsedTime);
    }

    private static void anyKingOlderThan80Imperative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        boolean isAnyKingOlderThan80 = false;
        for (King king : kingsOfPoland) {
            if (king.getAge() > 80) {
                isAnyKingOlderThan80 = true;
                break;
            }
        }
        System.out.println(isAnyKingOlderThan80);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time anyKingOlderThan80Imperative: " + elapsedTime);
    }

    private static void anyKingOlderThan80Declarative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        boolean isAnyKingOlderThan80 = kingsOfPoland.stream()
                .anyMatch(king -> king.getAge() > 80);
        System.out.println(isAnyKingOlderThan80);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time anyKingOlderThan80Declarative: " + elapsedTime);
    }

    private static void areAllKingsOlderThan20Imperative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        boolean areAllOlderThan20 = true;
        for (King king : kingsOfPoland) {
            if (king.getAge() <= 20) {
                areAllOlderThan20 = false;
            }
        }
        System.out.println(areAllOlderThan20);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time areAllKingsOlderThan20Imperative: " + elapsedTime);
    }

    private static void areAllKingsOlderThan20Declarative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        boolean areAllOlderThan20 = kingsOfPoland.stream()
                .allMatch(king -> king.getAge() > 20);
        System.out.println(areAllOlderThan20);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time areAllKingsOlderThan20Declarative: " + elapsedTime);
    }

    private static void getFemaleKingsImperative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        List<King> females = new ArrayList<>();
        for (King king : kingsOfPoland) {
            if (king.getGender().equals(Gender.FEMALE)) {
                females.add(king);
            }
        }
        females.forEach(System.out::println);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time getFemaleKingsImperative: " + elapsedTime);
    }

    private static void getFemaleKingsDeclarative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        List<King> females = kingsOfPoland.stream()
                .filter(king -> king.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females.forEach(System.out::println);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time getFemaleKingsDeclarative: " + elapsedTime);
    }

    private static List<King> getKings() {
        return Arrays.asList(
                new King("Bolesław I the Brave", 58, Gender.MALE),
                new King("Bolesław III Wrymouth", 52, Gender.MALE),
                new King("Casimir III the Great", 60, Gender.MALE),
                new King("Jadwiga of Poland", 25, Gender.FEMALE),
                new King("Sigismund I the Old", 81, Gender.MALE)
        );
    }
}
