package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by xiaofengfu on 2017/10/20.
 */
public interface IUserManager extends Remote{

    public String getUsername() throws RemoteException;

    public UserAccount getUser() throws RemoteException;
}
