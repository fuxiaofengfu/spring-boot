package rmi;

import enums.GenderEnum;

import java.rmi.RemoteException;

/**
 * Created by xiaofengfu on 2017/10/20.
 */
public class UserManagerImpl implements IUserManager {

    public UserManagerImpl() throws RemoteException {
        //super(port);
    }

    @Override
    public String getUsername() throws RemoteException{
        return "getUsername";
    }

    @Override
    public UserAccount getUser() throws RemoteException{
        UserAccount userAccount = new UserAccount();
        userAccount.setAge("13");
        userAccount.setGender(GenderEnum.FEMALE.gender);
        userAccount.setUsername("哈哈");
        return userAccount;
    }
}
