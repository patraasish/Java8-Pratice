package ps5.q1;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TestPerson2 {

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
		
	     // 1. Print all persons using Streams and Method Reference
        System.out.println("--Print all the person records--");
        personSet.stream().forEach(System.out::println);
        
        // 2. Print all persons sorted by id in ascending order using Comparable and Streams
        System.out.println("--Sorted Asc Id--");
        personSet.stream()
                .sorted()
                .forEach(System.out::println);
        
        // 3. Print all persons sorted by name in ascending order using Comparator and Streams
        System.out.println("--Sorted Asc Name--");
        personSet.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
        
        // 4. Print all persons sorted by name in descending order using Comparator and Streams
        System.out.println("--Sorted Desc Name--");
        personSet.stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .forEach(System.out::println);
        
        // 5. Print all persons whose Name starts with "J" using Streams
        System.out.println("--Name start with J--");
        personSet.stream()
                .filter(person -> person.getName().startsWith("J"))
                .forEach(System.out::println);
        
        // 6. Print the count number of persons using Streams
        System.out.println("--Count number of persons--");
        long count = personSet.stream().count();
        System.out.println(count);
        
        // 7. Print the Max salary among all persons using Streams
        System.out.println("--Max salary among all persons--");
        OptionalDouble maxSalary = personSet.stream().mapToDouble(Person::getSalary).max();
        System.out.println(maxSalary);
        
        // 8. Print the Min salary among all persons using Streams
        System.out.println("--Min salary among all persons--");
        OptionalDouble minSalary = personSet.stream().mapToDouble(Person::getSalary).min();
        System.out.println(minSalary);
        
        // 10. Print the sum of all salaries using Streams
        System.out.println("--Sum of all salaries--");
        double sumSalary = personSet.stream().mapToDouble(Person::getSalary).sum();
        System.out.println(sumSalary);
        
        // 11. Print the first Person whose Name starts with "J" using Streams - filter and findFirst method
        System.out.println("--First Person whose Name starts with J--");
        Optional<Person> firstJPerson = personSet.stream()
                .filter(person -> person.getName().startsWith("J"))
                .findFirst();
        System.out.println(firstJPerson.orElse(null));
        
        // 12. Check whether all the persons age is greater than 10 using Streams - allMatch method
        System.out.println("--Return true if All person age greater than 10--");
        boolean ageGreaterThan10 = personSet.stream().allMatch(person -> person.getAge() > 10);
        System.out.println(ageGreaterThan10);
        
        // 13. Check whether all the persons age is greater than 50 using Streams - noneMatch method
        System.out.println("--Return true if All person age greater than 50--");
        boolean allGreaterThan50 = personSet.stream().noneMatch(person -> person.getAge() > 50);
        System.out.println(allGreaterThan50);
        
        // 14. Print the average of all salaries using Streams and Collectors
        System.out.println("--Average salaries to Double--");
        double avgSalary = personSet.stream().collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println(avgSalary);
        
        // 15. Print all the persons details grouped by salary using Streams and Collectors
        System.out.println("--Group By Salary--");
        Map<Double, List<Person>> groupedBySalary = personSet.stream()
                .collect(Collectors.groupingBy(Person::getSalary));
        groupedBySalary.forEach((salary, persons) -> {
            System.out.println("Person Grouped By: " + salary);
            persons.forEach(System.out::println);
        });
        
        // 16. Print all the names after joining whose age is greater than 18 using Streams and Collectors
        System.out.println("--Joining all the names whose age is greater than 18--");
        String joinedNames = personSet.stream()
                .filter(person -> person.getAge() > 18)
                .map(Person::getName)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
        System.out.println(joinedNames);
        
        
        // 17. Print the Min, Max, Count, Average, and Sum of all persons using Statistics and Collectors
        System.out.println("\n--Statistics object--");
        DoubleSummaryStatistics stats = personSet.stream()
                .collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println("Statistics object\n" + stats);

        System.out.println("Minimum is: " + stats.getMin());
        System.out.println("Maximum is: " + stats.getMax());
        System.out.println("Count is: " + stats.getCount());
        System.out.println("Average is: " + stats.getAverage());
        System.out.println("Sum is: " + stats.getSum());
        // 18. Determine the oldest person among all using Streams and Reduce
        System.out.println("\n--Determine the oldest person--");
        Optional<Person> oldestPerson = personSet.stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);
        System.out.println(oldestPerson.orElse(null));

        // 19. Add n number of multiple records and print the time taken with sequential using stream
        int n = 1000000;
        Set<Person> largePersonSet = new HashSet<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            largePersonSet.add(new Person(i, "Person" + i, i % 100, i * 100.0));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("--Performing Sequentially: ");
        
        // Calculating and printing time taken
        long timeTaken = endTime - startTime;
        System.out.println("Time taken with parallel: " + timeTaken + " milliseconds");

    }

	}


