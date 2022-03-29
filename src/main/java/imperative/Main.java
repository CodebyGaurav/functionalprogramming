package imperative;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args){
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Alex", FEMALE),
                new Person("Don", MALE),
                new Person("Alex", FEMALE),
                new Person("Dora", FEMALE)
        );
        System.out.println("Imperative");
        //Imperative approach
        List<Person> females = new ArrayList<>();
        for (Person person : people){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        for (Person female : females){
            System.out.println(female);
        }

        // declarative approach
        System.out.println("Declarative");
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);   // Predicate return true or false
        List<Person> personList = people.stream()
                        .filter(personPredicate)
                        .collect(Collectors.toList());
        personList.forEach(System.out::println);



    }

    static class Person {
        private final String name;
        private final Gender gender;


        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE, FEMALE
    }
}
