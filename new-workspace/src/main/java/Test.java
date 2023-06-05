import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    private static List<String> names = Arrays.asList("Sara","John","Sat","Mark","Ram");
   // List<String> names1 = ["Sara","John","Sat","Mark","Ram"];
    public static void main(String[] args) {
        names.stream().filter(x -> x.startsWith("S")).collect(Collectors.toList()).forEach(System.out::println);
    }
}