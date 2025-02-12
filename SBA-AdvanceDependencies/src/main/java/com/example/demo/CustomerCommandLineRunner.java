package com.example.demo;


import com.example.demo.Customer;
import com.example.demo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerCommandLineRunner implements CommandLineRunner {
    private final CustomerRepository repository;

    public CustomerCommandLineRunner(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        // Save sample customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

        // Print all customers
        System.out.println("\n== Customers found with findAll():");
        System.out.println("----------------------------------------");
        repository.findAll().forEach(System.out::println);

        // Find by ID
        System.out.println("\n== Customer found with findById(1L):");
        System.out.println("----------------------------------------");
        repository.findById(1L).ifPresent(System.out::println);

        // Find by Last Name
        System.out.println("\n== Customer found with findByLastName('Bauer'):");
        System.out.println("------------------------------------------------");
        repository.findByLastName("Bauer").forEach(System.out::println);
    }
}
