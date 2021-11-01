
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Main {

  
  private static List<Person> getPeople() {
    return List.of(
        new Person("Antonio", 20, Gender.MALE),
        new Person("Alina Smith", 33, Gender.FEMALE),
        new Person("Helen White", 57, Gender.FEMALE),
        new Person("Alex Boz", 14, Gender.MALE),
        new Person("Jamie Goa", 99, Gender.MALE),
        new Person("Anna Cook", 7, Gender.FEMALE),
        new Person("Zelda Brown", 120, Gender.FEMALE)
    );
  }

  public static void main(String[] args) {

    // IMPERATIVE APPROACH 

    List<Person> people = getPeople();

    /* List<Person> females = new ArrayList<>();

      for (Person person: people){

       if (person.getGender().equals(Gender.FEMALE)) 

         females.add(person);
      
     }
        females.forEach(System.out::println);
    */
    //DECLARTIVE APPROACH
    //FILTER
    List<Person> females = people.stream()
      .filter(person -> person.getGender().equals(Gender.FEMALE))
      .collect(Collectors.toList());

    // females.forEach(System.out::print);
  
    //SORT
    List<Person> sortedAge = people.stream()
    .sorted(Comparator.comparing(Person::getAge))
    .collect(Collectors.toList());

    // sortedAge.forEach(System.out::println);


    //ALL MATCH
    boolean allMatch  = people.stream().allMatch(person -> person.getAge() > 5);
    // System.out.println(allMatch);

    //ANY MATCH
    boolean anyMatch = people.stream().anyMatch(person -> person.getAge() > 1000);
    // System.out.println(anyMatch);


    //NONE MATCH
    boolean noneMatch = people.stream().noneMatch(person -> person.getName().equals("Zelda Brown"));
    // System.out.println(noneMatch);

    //MAX
    people.stream()
    .max(Comparator.comparing(Person::getAge))
    .ifPresent(System.out::println);

    //MIN 
    people.stream()
    .min(Comparator.comparing(Person::getAge))
    .ifPresent(System.out::println);


    //GROUP
    //GROUP BY GENDER
    Map<Gender, List<Person>> groupByGender = people.stream()
    .collect(Collectors.groupingBy(Person::getGender));

  //  groupByGender.forEach((gender, people1) -> {
  //    System.out.println(gender + "2");
  //    people1.forEach(System.out::println);
  //    System.out.println();
  //  });


   Optional<String> oldestFemale = people.stream()
   .filter(person -> person.getGender().equals(Gender.FEMALE))
   .max(Comparator.comparing(Person::getAge))
   .map(Person::getName);

  //  oldestFemale.ifPresent(System.out::println);

  List<Integer> list = Arrays.asList(10, 1, -4, 3, 18);
  
  List<Integer> sortedList = list.stream().sorted().filter(num -> num % 2 == 0).collect(Collectors.toList());

  System.out.println(list);
  System.out.println(sortedList);


  }


}
