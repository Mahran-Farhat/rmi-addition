package com.example.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import com.example.shared.Addition;

public class AdditionClient {

   public static int readNumber() {
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
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Addition addition = (Addition) registry.lookup("AdditionService");
            int a = readNumber();
            int b = readNumber();
            int result = addition.add(a, b);
            System.out.println("Result of "+a+" + "+b+" is: " + result);
        } catch (Exception e) {
            System.out.println("Found a solution to the problem");
            e.printStackTrace();
        }
    }
}

