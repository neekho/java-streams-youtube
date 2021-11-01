import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


// interface communicateUser {
//     void greet(String name);
// }

public class Test {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        List<String> people = Arrays.asList("John", "Mark", "Anthony", "Rastaman", "Nico");

        List<String> sortedPeople = people.stream()
        .sorted(Comparator.naturalOrder())
        .filter(person -> person.contains("a") || person.contains("A"))
        .collect(Collectors.toList());
        
        sortedPeople.forEach(i -> System.out.println(i));
        

        List<Integer> numbers = Arrays.asList(2, 28 ,3 ,5 ,3 ,0 ,7, 5, 4);
        List<Integer> sortedNumbers = numbers.stream().sorted().filter(number -> number % 2 != 0).collect(Collectors.toList());

        sortedNumbers.forEach(System.out::println);
      
        for (;;) {

            System.out.println("search:");
            String searchInput = sc.next();

            List<String> searchPeople = people.stream()
            .sorted()
            .filter(person -> person.contains(searchInput))
            .collect(Collectors.toList()); 


            System.out.println("Result:");
            searchPeople.forEach(System.out::println);
        }



        
    }
}