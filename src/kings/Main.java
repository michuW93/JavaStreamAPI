package kings;

import java.util.*;
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

        System.out.println();

        computeSumOfSquaresAllKingsAgeImperative(kingsOfPoland);    //431900   36200
        computeSumOfSquaresAllKingsAgeDeclarative(kingsOfPoland);   //3691500  2062300

        System.out.println();

        numberOfKingsBySexImperative(kingsOfPoland);    //32501       30899
        numberOfKingsBySexDeclarative(kingsOfPoland);   //6173500     5371200

        System.out.println();

        getNamesOfMaleKingsImperative(kingsOfPoland);  //35399     43400
        getNameOfMaleKingsDeclarative(kingsOfPoland);  //2137801   2428900

        System.out.println();

        getKingsStartWithBImperative(kingsOfPoland);   //318500     1932800
        getKingsStartWithBDeclarative(kingsOfPoland);  //29990400   1961900

        System.out.println();

        getFirstKingFromListImperative(kingsOfPoland);  //204900    357100
        getFirstKingFromListDeclarative(kingsOfPoland); //36169000  2068200
    }

    private static void getNamesOfMaleKingsImperative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        String namesOfMaleKings = "";
        for (King king : kingsOfPoland) {
            if (king.getGender().equals(Gender.MALE)) {
                namesOfMaleKings = namesOfMaleKings + king.getName() + ", ";
            }
        }
        namesOfMaleKings = namesOfMaleKings.substring(0, namesOfMaleKings.length() - 1);
        System.out.println(namesOfMaleKings);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time getNameOfMaleKingsDeclarative: " + elapsedTime);
    }

    private static void getNameOfMaleKingsDeclarative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        String namesOfMaleKings = kingsOfPoland.stream()
                .filter(king -> king.getGender().equals(Gender.MALE))
                .map(King::getName)
                .collect(Collectors.joining(", "));
        System.out.println(namesOfMaleKings);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time getNameOfMaleKingsDeclarative: " + elapsedTime);
    }

    private static void numberOfKingsBySexImperative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        int numOfMale = 0;
        int numOfFemale = 0;
        for (King king : kingsOfPoland) {
            if (king.getGender().equals(Gender.MALE)) {
                numOfMale++;
            } else {
                numOfFemale++;
            }
        }
        System.out.println(numOfMale + " " + numOfFemale);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time numberOfKingsBySexDeclarative: " + elapsedTime);
    }

    private static void numberOfKingsBySexDeclarative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        Map<Gender, Long> countByGender = kingsOfPoland.stream()
                .collect(Collectors.groupingBy(King::getGender, Collectors.counting()));
        System.out.println(countByGender);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time numberOfKingsBySexDeclarative: " + elapsedTime);
    }

    private static void computeSumOfSquaresAllKingsAgeImperative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        int sum = 0;
        for (King king : kingsOfPoland) {
            int square = king.getAge() * king.getAge();
            sum = sum + square;
        }
        System.out.println(sum);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time computeSumOfAllKingsAgeImperative: " + elapsedTime);
    }

    private static void computeSumOfSquaresAllKingsAgeDeclarative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        Integer sum = kingsOfPoland.stream()
                .map(king -> king.getAge() * king.getAge())
                .reduce(0, Integer::sum);
        System.out.println(sum);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time computeSumOfAllKingsAgeDeclarative: " + elapsedTime);
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
                .ifPresent(System.out::println);
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

    private static void getKingsStartWithBImperative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        List<King> kingsOnB = new ArrayList<>();
        for (King king : kingsOfPoland) {
            if (king.getName().startsWith("B")) {
                System.out.println(king.getName().toUpperCase());
            }
        }
        kingsOnB.forEach(System.out::println);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time getKingsStartWithBImperative: " + elapsedTime);
    }

    private static void getKingsStartWithBDeclarative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        kingsOfPoland.stream()
                .filter(s -> s.getName().startsWith("B"))
                .map(king -> king.getName().toUpperCase())
                .forEach(System.out::println);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time getKingsStartWithBDeclarative: " + elapsedTime);
    }

    private static void getFirstKingFromListImperative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        System.out.println(kingsOfPoland.get(0));
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time getFirstKingFromListImperative: " + elapsedTime);
    }

    private static void getFirstKingFromListDeclarative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        kingsOfPoland.stream()
                .findFirst()
                .ifPresent(System.out::println);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time getFirstKingFromListDeclarative: " + elapsedTime);
    }

    private static List<King> getKings() {
        return Arrays.asList(
                new King("Bolesław I the Brave", 58, Gender.MALE),
                new King("Bolesław II the Generous", 52, Gender.MALE),
                new King("Bolesław III Wrymouth", 52, Gender.MALE),
                new King("Casimir III the Great", 60, Gender.MALE),
                new King("Jadwiga of Poland", 25, Gender.FEMALE),
                new King("Sigismund I the Old", 81, Gender.MALE)
        );
    }
}
