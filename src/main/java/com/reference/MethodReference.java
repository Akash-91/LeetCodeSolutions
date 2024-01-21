package com.reference;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

// Suppose you have a functional interface with one method like this:
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

// You can reference a static method like this:
class StringConverter {
    public static Integer toInt(String str) {
        return Integer.parseInt(str);
    }
}

@FunctionalInterface
interface PersonFactory<P extends Person> {
    P create(String name);
}


class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printName() {
        System.out.println(name);
    }

    public void printUpto100() {
        IntStream.range(1, 10).forEach(i -> System.out.println(Thread.currentThread().getName() + " : " + i));
    }
}

public class MethodReference {
    public static void main(String[] args) {
        Converter<String, Integer> converter = StringConverter::toInt;
        Integer result = converter.convert("123");
        System.out.println(result); // Output: 123


        Person person = new Person("John");
        Runnable runnable = person::printName;
        runnable.run(); // Output: John

        Runnable runnable2 = person::printUpto100;
        runnable2.run(); // Output: John


        ExecutorService executor = Executors.newFixedThreadPool(5); // Create a thread pool with 5 threads
        Runnable myRunnable = () -> {
            System.out.println("Hello from the Runnable!");
        };
        executor.execute(myRunnable); // Execute the Runnable in a thread from the pool
// Don't forget to shut down the executor when you're done
        executor.shutdown();


        PersonFactory<Person> personFactory = Person::new;
        Person person1 = personFactory.create("John");
        System.out.println(person1.getName()); // Output: John
    }
}
