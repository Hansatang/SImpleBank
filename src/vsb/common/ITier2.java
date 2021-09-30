/*
 * 12.09.2018 Original version
 */

package vsb.common;

import vsb.model.Account;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;


public interface ITier2 extends Remote {
    public static final String T2_SERVICE_NAME = "rmi://localhost:1099/T2";

    public Account withdraw(int accountNumber, double amount) throws RemoteException, SQLException;

    public Account insert(int accountNumber, double amount) throws RemoteException, SQLException;

    public Account createAccount(int accountNumber) throws RemoteException;

    public void saveClient(String userTypedText, ITier1 tier1Customer) throws RemoteException;
}
