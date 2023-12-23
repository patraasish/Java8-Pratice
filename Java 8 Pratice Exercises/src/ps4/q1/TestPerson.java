package ps4.q1;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;


public class TestPerson {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		Set<Person> personSet = new TreeSet<>();
		for(int i=0;i<2;i++) {
			int id,age;
			String name;
			double salary;
			System.out.println("Enter id: ");
			id=sc.nextInt();
			System.out.println("Enter name: ");
			name=sc.next();
			System.out.println("Enter age: ");
			age=sc.nextInt();
			System.out.println("Enter salary: ");
			salary=sc.nextDouble();
			personSet.add(new Person(id, name, age, salary));
		}
		
		System.out.println(personSet);
		
		// 1. Print all persons using Method Reference
        System.out.println("--Sorted by ID--");
        personSet.forEach(System.out::println);
        
        // 2. Print all persons sorted by name in ascending order using Comparator
        System.out.println("\n--Sorted Asc Name--");
        personSet.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
        
        // 3. Print all persons sorted by name in descending order using Comparator
        System.out.println("\n--Sorted Desc Name--");
        personSet.stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .forEach(System.out::println);
        
        // 4. Print persons whose age is greater than 25 using Predicate
        System.out.println("\n--Age is greater than 25--");
        personSet.stream()
                .filter(person -> person.getAge() > 25)
                .forEach(System.out::println);
        
        // 5. Print id, name, and salary using Consumer
        System.out.println("\n--Print id, name, and salary--");
        Consumer<Person> printDetails = person ->
                System.out.println(person.getId() + " " + person.getName() + " " + person.getSalary() );
        personSet.forEach(printDetails);

        // 6. Print all names in Uppercase using Function
        System.out.println("\n--All names in Uppercase--");
        Function<Person, String> toUpperCase = person -> person.getName().toUpperCase();
        personSet.stream()
                .map(toUpperCase)
                .forEach(System.out::println);

        // 7. Print names and salary after applying a 10% appraisal using ToDoubleFunction
        System.out.println("\n--Applying appraisal to salary--");
        ToDoubleFunction<Person> applyAppraisal = person -> person.getSalary() * 1.1;
        personSet.forEach(person ->
                System.out.println("Name is: " + person.getName() + " and Salary is: " + applyAppraisal.applyAsDouble(person)));
    }

	}


