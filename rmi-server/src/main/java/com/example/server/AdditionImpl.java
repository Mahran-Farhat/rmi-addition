package com.example.server;

import java.rmi.server.UnicastRemoteObject;

import com.example.shared.Addition;

import java.rmi.RemoteException;

public class AdditionImpl extends UnicastRemoteObject implements Addition {
    protected AdditionImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        System.out.println("Calculate the total of "+a+" + "+b);
        return a + b;
    }
}
