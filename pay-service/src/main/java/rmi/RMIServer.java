package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by xiaofengfu on 2017/10/20.
 */
public class RMIServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        IUserManager iUserManager = new UserManagerImpl();
       // Naming.rebind("testrmi",iUserManager);
        iUserManager = (IUserManager)UnicastRemoteObject.exportObject(iUserManager,8081);
        Registry registry = LocateRegistry.createRegistry(8080);
        registry.rebind("userManager", iUserManager);
        System.out.println("server is ready");
    }
}
