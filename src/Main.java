import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        List<King> kingsOfPoland = getKings();

        getFemaleKingsImperative(kingsOfPoland);  //65192700
        getFemaleKingsDeclarative(kingsOfPoland); //12944700

    }

    private static void getFemaleKingsImperative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        List<King> females = new ArrayList<>();
        for (King king : kingsOfPoland){
            if(king.getGender().equals(Gender.FEMALE)){
                females.add(king);
            }
        }
        females.forEach(System.out::println);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time getFemaleKingsImperative: " + elapsedTime);
    }

    private static void getFemaleKingsDeclarative(List<King> kingsOfPoland) {
        long start = System.nanoTime();
        List<King> females = new ArrayList<>();
        females = kingsOfPoland.stream()
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
