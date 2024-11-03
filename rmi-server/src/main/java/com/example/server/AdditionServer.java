package com.example.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.example.shared.Addition;

public class AdditionServer {
    public static void main(String[] args) {
        try {
            Addition addition = new AdditionImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("AdditionService", addition);
            System.out.println("Addition RMI server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

