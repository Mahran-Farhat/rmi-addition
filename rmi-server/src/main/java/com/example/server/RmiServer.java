package com.example.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.example.shared.Addition;
import com.example.shared.Service;

public class RmiServer {
    public static void main(String[] args) {
        final int registryPort = 1099;
        try {
            Addition addition = new AdditionImpl();
            System.out.println("As a server, I will register the Addition service with the RMI registry...");
            Registry registry = getOrCreateRegistry(registryPort);
            registry.rebind(Service.AdditionService.name(), addition);
            System.out.println("Addition RMI server is running...");
        } catch (RemoteException e) {
            System.err.println("Failed to register Addition service in the RMI registry on port " + registryPort + ".");
            System.err.println("If an external rmiregistry is running, stop it and run this server again so it can create the registry.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Registry getOrCreateRegistry(int port) throws RemoteException {
        try {
            Registry registry = LocateRegistry.createRegistry(port);
            System.out.println("Created an in-process RMI registry on port " + port + ".");
            return registry;
        } catch (RemoteException e) {
            Registry registry = LocateRegistry.getRegistry("localhost", port);
            registry.list();
            System.out.println("Using existing RMI registry on port " + port + ".");
            return registry;
        }
    }
}
