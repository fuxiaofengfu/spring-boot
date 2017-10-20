package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by xiaofengfu on 2017/10/20.
 */
public class RMIClient {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1",8080);
        IUserManager iUserManager = (IUserManager)registry.lookup("userManager");
        System.out.println(iUserManager.getUsername());
    }
}
