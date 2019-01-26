import java.lang.String;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        exampleFourteen();
//        exampleThirteen();
//        try {
//            exampleTwelve();
//            exampleEleven();
//            exampleTen();
//            exampleNine();
//            exampleEight();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //exampleSeven();
        // exampleSix();
        //exampleFive();
        //exampleFour();
        //exampleTri();
        //exampleDuo();
        //exampleUno();
        //System.out.println("Hello World");

    }

    public static void exampleUno() {
        IntStream
                .range(1, 10)
                .forEach(System.out::print);
        System.out.println();
    }

    public static void exampleDuo() {
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println();
    }

    public static void exampleTri() {
        System.out.println(
                IntStream
                        .range(1, 5)
                        .sum());
        System.out.println();
    }

    public static void exampleFour() {
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void exampleFive() {
        String[] names = {"Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivka", "Sarah"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
    }

    public static void exampleSix() {
        Arrays.stream(new int[]{2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
    }

    public static void exampleSeven() {
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivi");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
    }

    public static void exampleEight() throws IOException {
        Stream<String> bands = Files.lines(Paths.get("C:/Users/Rassiq/IdeaProjects/streamsTurtorial/resources/bands.txt"));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close();

    }

    public static void exampleNine() throws IOException {
        List<String> bands2 = Files.lines(Paths.get("C:/Users/Rassiq/IdeaProjects/streamsTurtorial/resources/bands.txt"))
                .filter(x -> x.contains("abc"))
                .collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));
    }

    public static void exampleTen() throws IOException {
        Stream<String> rows1 = Files.lines(Paths.get("C:/Users/Rassiq/IdeaProjects/streamsTurtorial/resources/data.txt"));
        int rowCount = (int) rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();
    }

    public static void exampleEleven() throws IOException {
        Stream<String> rows2 = Files.lines(Paths.get("C:/Users/Rassiq/IdeaProjects/streamsTurtorial/resources/data.txt"));
        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        rows2.close();

    }

    public static void exampleTwelve() throws IOException {
        Stream<String> rows3 = Files.lines(Paths.get("C:/Users/Rassiq/IdeaProjects/streamsTurtorial/resources/data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])));
        rows3.close();
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }

    public static void exampleThirteen() {
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = "+ total);
    }
    public static void exampleFourteen(){
        IntSummaryStatistics summary= IntStream.of(7,2,19,88,73,4,10)
                .summaryStatistics();
        System.out.println(summary);
    }
}
