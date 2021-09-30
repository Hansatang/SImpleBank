/*
 * 12.09.2018 Original version
 */

package vsb.tier3;

import vsb.common.ITier3;
import vsb.model.Account;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

public class Tier3Controller extends UnicastRemoteObject implements ITier3 {
    private final Connection connection =
            DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qwerty");
    private final Statement statement = connection.createStatement();

    public Tier3Controller() throws RemoteException, SQLException {
        try {
            Naming.rebind(T3_SERVICE_NAME, this);
            //  getAccounts();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public Account getAccount(int accountNumber) throws RemoteException, SQLException {
        Account account = null;
        ResultSet resultSet = statement.executeQuery
                ("SELECT * FROM bank.accounts WHERE id = " + accountNumber);
        while (resultSet.next()) {
            account = new Account(resultSet.getInt(1), resultSet.getDouble(2));
        }
        return account;
    }

    public void getAccounts() throws RemoteException, SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM bank.accounts ");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getDouble(2));
        }

    }

    public Account updateAccount(Account account) throws RemoteException {
        try {
            statement.execute
                    ("UPDATE bank.accounts SET balance = " + account.getBalance()
                            + " WHERE id = " + account.getNumber());
            return getAccount(account.getNumber());

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return null;
    }


    public Account createAccount(Account account) {
        try {
            statement.execute("INSERT INTO bank.accounts (id,balance) VALUES ("
                    + account.getNumber() + "," + account.getBalance() + ")");
            return getAccount(account.getNumber());
        } catch (SQLException | RemoteException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return null;
    }


}

