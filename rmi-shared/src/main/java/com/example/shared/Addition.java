package com.example.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;





public interface Addition extends Remote {
    Integer add(Integer a, Integer b) throws RemoteException;
}
