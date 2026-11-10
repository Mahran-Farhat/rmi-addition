package com.example.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import com.example.shared.Addition;
import com.example.shared.Service;

public class AdditionClient {

   public static Integer readNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter an integer: ");
            try {
                number = Integer.parseInt(scanner.nextLine());
                validInput = true; // Input is valid, exit loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        
        return number;
    }
    public static void main(String[] args) {
        try {

            Integer a = readNumber();
            Integer b = readNumber();

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Addition addition = (Addition) registry.lookup(Service.AdditionService.name());
            System.out.println("Successfully connected to the Addition RMI service. " +
                    "We will use it");
            Integer result = addition.add(a, b);
            System.out.println("Waiting for 10 seconds before displaying the result...");
            Thread.sleep(10000);
            System.out.println("Result of "+a+" + "+b+" is: " + result);

        } catch (Exception e) {
            System.out.println("Found a solution to the problem");
            e.printStackTrace();
        }
    }
}

