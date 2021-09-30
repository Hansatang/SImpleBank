/*
 * 12.09.2018 Original version
 */


package vsb.common;


import vsb.model.Account;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;


public interface ITier3 extends Remote {
    public static final String T3_SERVICE_NAME = "rmi://localhost:1099/T3";

    public Account getAccount(int accountNumber) throws RemoteException, SQLException;

    public Account createAccount(Account account) throws RemoteException;

    public Account updateAccount(Account account) throws RemoteException;
}
